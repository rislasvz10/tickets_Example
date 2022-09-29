/*
* Copyright © 2021 by LocalHost. All rights reserved.
* LocalHost claims copyright in this computer program as an unpublished work,
* one or more versions of which were first used to provide services to
* customers on the dates indicated in the foregoing notice. Claim of
* copyright does not imply waiver of other rights.
*
* NOTICE OF PROPRIETARY RIGHTS
*
* This program is a confidential trade secret and the property of LocalHost.
* Use, examination, reproduction, disassembly, decompiling, transfer and/or
* disclosure to others of all or any part of this software program are
* strictly prohibited except by express written agreement with LocalHost.
*/

package com.local.learning.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.local.learning.constant.ApiConstants;
import com.local.learning.constant.ErrorResolverConstants;
import com.local.learning.constant.SpecialCharacterConstants;
import com.multiva.learning.exception.ErrorResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller advice class for handling errors.
 *
 * @author Empresa.
 */
@RestControllerAdvice
@Slf4j
public class ErrorResolver {

  /**
   * Injected bean to retrieve the constants defined in external yaml file.
   */
  @Autowired
  private ErrorResolverConstants errorResolverConstants;

  /**
   * Method to write the error details to logging.
   *
   * @param errorResponse an ErrorResponse object.
   * @param exception     an Exception Throwable.
   */
  private static void writeToLog(com.multiva.learning.exception.ErrorResponse errorResponse, Exception exception) {
    log.error(ErrorResolverConstants.ERROR_RESPONSE_TYPE, errorResponse.getType());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_CODE, errorResponse.getCode());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_DETAILS, errorResponse.getDetails());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_LOCATION, errorResponse.getLocation());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_MORE_INFORMATION, errorResponse.getMoreInfo());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_UUID, errorResponse.getUuid());
    log.error(ErrorResolverConstants.ERROR_RESPONSE_TIME_STAMP, errorResponse.getTimestamp());

    String message = ObjectUtils.isEmpty(exception) ? SpecialCharacterConstants.EMPTY_STRING
            : exception.getMessage();

    log.error(message, exception);
  }

  /**
   * For illegal argument exceptions in the application.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type NoHandlerFoundException.
   * @return errorResponse object.
   */
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ErrorResponseOpt handlerBusinessException(HttpServletRequest req,
      IllegalArgumentException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);
    errorResponse.setCode(errorResolverConstants.getBusinessValidationFailed());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);
    return new ErrorResponseOpt(Long.valueOf(errorResolverConstants.getBusinessValidationFailed()),
        ex.getMessage(), errorResponse);
  }

  /**
   * dataBaseErrorException Method, for illegal argument exceptions in the application.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type InvalidDataAccessResourceUsageException.
   * @return errorResponse object.
   */
  @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse dataBaseErrorException(HttpServletRequest req,
      InvalidDataAccessResourceUsageException ex) {
    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);

    errorResponse.setCode(errorResolverConstants.getNotFoundException());
    errorResponse.setDetails(errorResolverConstants.getNotFoundTable());
    errorResponse.setLocation(this.getClass().getSimpleName());

    ErrorResolver.writeToLog(errorResponse, ex);
    return errorResponse;
  }

  /**
   * Handler for ConstraintViolationException.
   *
   * @param req HttpServletRequest.
   * @param ex  of type ConstraintViolationException.
   * @return errorResponse object.
   */
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveConstraintViolation(HttpServletRequest req,
      ConstraintViolationException ex) {

    List<String> violationMessages = new ArrayList<>();
    ex.getConstraintViolations().forEach(
        violation -> violationMessages.add(violation.getMessage())
    );

    com.multiva.learning.exception.ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getConstraintViolationException());
    errorResponse.setDetails(String.join(SpecialCharacterConstants.COMMA, violationMessages));

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for HttpRequestMethodNotSupportedException.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type HttpRequestMethodNotSupportedException.
   * @return errorResponse object.
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpRequestMethodNotSupportedException(HttpServletRequest req,
      HttpRequestMethodNotSupportedException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getMethodNotSupportedException());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for HttpMediaTypeNotAcceptableException.
   *
   * @param req The httpRequest as in the Servlet API.
   * @param ex  of type HttpMediaTypeNotAcceptableException.
   * @return errorResponse object.
   */
  @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String resolveHttpMediaTypeNotAcceptableException(HttpServletRequest req,
      HttpMediaTypeNotAcceptableException ex) {
    ObjectMapper mapper = new ObjectMapper();

    ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getUnaceptableMediaTypeException());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    String errorResponseString = ex.getMessage();

    try {
      errorResponseString = mapper.writeValueAsString(errorResponse);
    } catch (JsonProcessingException jsonProcessingException) {
      log.error(jsonProcessingException.getMessage(), jsonProcessingException);
    }

    return errorResponseString;
  }

  /**
   * Handler for HttpMediaTypeNotSupportedException.
   *
   * @param req The httpRequest as in the Servlet API.
   * @param ex  of type HttpMediaTypeNotSupportedException.
   * @return errorResponse object.
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMediaTypeNotSupportedException(HttpServletRequest req,
      HttpMediaTypeNotSupportedException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getUnsupportedMediaTypeException());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for ServletRequestBindingException.
   *
   * @param req The httpRequest as in the Servlet API.
   * @param ex  of type ServletRequestBindingException.
   * @return errorResponse object.
   */
  @ExceptionHandler(ServletRequestBindingException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveServletRequestBindingException(HttpServletRequest req,
      ServletRequestBindingException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);
    errorResponse.setCode(errorResolverConstants.getServletRequestBindingException());
    if (!ObjectUtils.isEmpty(ex.getMessage())) {
      errorResponse.setDetails(ex.getMessage());
    }

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for HttpMessageNotReadableException.
   *
   * @param req HttpServletRequest param.
   * @param ex  of type HttpMessageNotReadableException.
   * @return errorResponse object.
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMessageNotReadableException(HttpServletRequest req,
      HttpMessageNotReadableException ex) {

    String message = ObjectUtils.isEmpty(ex) ? SpecialCharacterConstants.EMPTY_STRING
        : ex.getMessage();
    message = ObjectUtils.isEmpty(message) ? SpecialCharacterConstants.EMPTY_STRING : message;
    int index = message.indexOf(SpecialCharacterConstants.COLON);
    message = (index != SpecialCharacterConstants.INT_NEGATIVE_1)
        ? message.substring(SpecialCharacterConstants.VALUE_INT_0, index)
        : errorResolverConstants.getGenericErrorDescription();

    ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getHttpMessageNotReadableException());
    errorResponse.setDetails(message);

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for MethodArgumentNotValidException.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type MethodArgumentNotValidException.
   * @return errorResponse object.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
      MethodArgumentNotValidException ex) {

    Map<String, List<String>> groupedErrors = new HashMap<>();
    List<String> fields = new ArrayList<>();
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    for (FieldError fieldError : fieldErrors) {
      String message = fieldError.getDefaultMessage();
      String field = fieldError.getField();
      groupedErrors.computeIfAbsent(message, key -> Collections.singletonList(field));
      fields.add(field);
    }

    ErrorResponse errorResponse = this.generateException(req, ErrorType.INVALID);
    errorResponse.setCode(errorResolverConstants.getMethodArgumentNotValidException());
    if (!groupedErrors.isEmpty()) {
      errorResponse.setDetails(groupedErrors.toString());
    }
    errorResponse.setLocation(fields.toString());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for Exception.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type Exception.
   * @return errorResponse object.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse resolveException(HttpServletRequest req, Exception ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.FATAL);
    errorResponse.setCode(errorResolverConstants.getInternalServerError());
    errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Handler for DataAccessResourceFailureException.
   *
   * @param req HttpServletRequest object.
   * @param ex  DataAccessException exception.
   * @return Error Response Object.
   */
  @ExceptionHandler(DataAccessResourceFailureException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse resolveDataAccessException(HttpServletRequest req, DataAccessException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);
    errorResponse.setCode(errorResolverConstants.getDatabaseMsClientException());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * For illegal argument exceptions in the application.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type NoHandlerFoundException.
   * @return errorResponse object.
   */
  @ExceptionHandler(UnsupportedOperationException.class)
  @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse handleApplicationErrorException2(HttpServletRequest req,
      UnsupportedOperationException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);
    errorResponse.setCode(errorResolverConstants.getNotFoundException());
    errorResponse.setDetails(ex.getMessage());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * for no result in the search.
   *
   * @param req of type HttpServletRequest.
   * @param ex  of type NoResultException.
   * @return errorResponse object.
   */
  @ExceptionHandler(NoResultException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveNoResultException(HttpServletRequest req,
      NoResultException ex) {

    ErrorResponse errorResponse = this.generateException(req, ErrorType.ERROR);
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setCode(errorResolverConstants.getNotFoundException());

    ErrorResolver.writeToLog(errorResponse, ex);

    return errorResponse;
  }

  /**
   * Assigns the values in the object.
   *
   * @param req of type HttpServletRequest.
   * @param errorType of type Enum.
   * @return an object of type ErrorResponse.
   */
  private ErrorResponse generateException(HttpServletRequest req, ErrorType errorType) {

    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setUuid(req.getHeader(ApiConstants.UUID));
    errorResponse.setType(errorType.name());
    errorResponse.setMoreInfo(req.getRequestURI());
    errorResponse.setTimestamp(ZonedDateTime.now());

    return errorResponse;
  }

}
