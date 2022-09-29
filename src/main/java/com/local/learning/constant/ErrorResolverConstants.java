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

package com.local.learning.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class used for management the errors.
 *
 * @author Empresa.
 */
@Getter
@Component
public class ErrorResolverConstants {

  /**
   * Constant used to represent an error code caused by a BadRequestException.
   */
  @Value("${constants.errorResolver.errorCodes.badRequestException}")
  private String badRequestException;

  /**
   * Constant used to represent an error code caused by an UnauthorizedException.
   */
  @Value("${constants.errorResolver.errorCodes.unauthorizedException}")
  private String unauthorizedException;

  /**
   * Constant used to represent an error code caused by a NotFoundException.
   */
  @Value("${constants.errorResolver.errorCodes.notFoundException}")
  private String notFoundException;

  /**
   * Constant used to represent an error code caused by a MethodNotSupportedException.
   */
  @Value("${constants.errorResolver.errorCodes.methodNotSupportedException}")
  private String methodNotSupportedException;

  /**
   * Constant used to represent an error code caused by a NotAcceptableMediaException.
   */
  @Value("${constants.errorResolver.errorCodes.unaceptableMediaTypeException}")
  private String unaceptableMediaTypeException;

  /**
   * Constant used to represent an error code caused by a UnsupportedMediaTypeException.
   */
  @Value("${constants.errorResolver.errorCodes.unsupportedMediaTypeException}")
  private String unsupportedMediaTypeException;

  /**
   * Constant used to represent an error message as description.
   */
  @Value("${constants.errorResolver.errorCodes.businessValidationFailed}")
  private String businessValidationFailed;

  /**
   * Constant used to represent an error code caused by a ServletRequestBindingException.
   */
  @Value("${constants.errorResolver.errorCodes.servletRequestBindingException}")
  private String servletRequestBindingException;

  /**
   * Constant used to represent an error code caused by a HttpMessageNotReadableException.
   */
  @Value("${constants.errorResolver.errorCodes.httpMessageNotReadableException}")
  private String httpMessageNotReadableException;

  /**
   * Constant used to represent an error code caused by a MethodArgumentNotValidException.
   */
  @Value("${constants.errorResolver.errorCodes.methodArgumentNotValidException}")
  private String methodArgumentNotValidException;

  /**
   * Constant used to represent an error code caused by a ConstraintViolationException.
   */
  @Value("${constants.errorResolver.errorCodes.constraintViolationException}")
  private String constraintViolationException;

  /**
   * Constant used to represent an error code caused by a InternalServerError.
   */
  @Value("${constants.errorResolver.errorCodes.internalServerError}")
  private String internalServerError;

  /**
   * Constant used to represent an error code caused by a HystrixRuntimeException.
   */
  @Value("${constants.errorResolver.errorCodes.hystrixRuntimeException}")
  private String hystrixRuntimeException;

  /**
   * Constant used to represent an error code caused by a DatabaseMsClientException.
   */
  @Value("${constants.errorResolver.errorCodes.databaseMsClientException}")
  private String databaseMsClientException;

  /**
   * Constant used to represent an error message as description.
   */
  @Value("${constants.errorResolver.messages.unauthorizedText}")
  private String unauthorizedText;

  /**
   * Constant used to represent an error message as description.
   */
  @Value("${constants.errorResolver.messages.genericErrorDescription}")
  private String genericErrorDescription;

  /**
   * Constant used to represent an error message as message.
   */
  @Value("${constants.errorResolver.messages.notFoundTable}")
  private String notFoundTable;

  /**
   * Message error for not found it on data base.
   */
  @Value("${constants.errorResolver.messages.notFoundError}")
  private String notFoundError;

  /**
   * Constant to represent the string 'errorResponse.type, {}'.
   */
  public static final String ERROR_RESPONSE_TYPE = "type: {}";

  /**
   * Constant to represent the string 'errorResponse.time_stamp, {}'.
   */
  public static final String ERROR_RESPONSE_TIME_STAMP = "time_stamp: {}";

  /**
   * Constant to represent the string 'errorResponse.code, {}'.
   */
  public static final String ERROR_RESPONSE_CODE = "code: {}";

  /**
   * Constant to represent the string 'errorResponse.details, {}'.
   */
  public static final String ERROR_RESPONSE_DETAILS = "details: {}";

  /**
   * Constant to represent the string 'errorResponse.code, {}'.
   */
  public static final String ERROR_RESPONSE_UUID = "uuid: {}";

  /**
   * Constant to represent the string 'errorResponse.details, {}'.
   */
  public static final String ERROR_RESPONSE_MESSAGE = "message: {}";

  /**
   * Constant to represent the string 'errorResponse.location, {}'.
   */
  public static final String ERROR_RESPONSE_LOCATION = "location: {}";

  /**
   * Constant to represent the string 'errorResponse.moreInfo, {}'.
   */
  public static final String ERROR_RESPONSE_MORE_INFORMATION = "moreInfo: {}";

  /**
   * Constant to represent the string 'errorResponse.moreInfo, {}'.
   */
  public static final String ERROR_RESPONSE_ADDITIONAL_INFORMATION = "additionalInformation: {}";

  /**
   * Private constructor will prevent the instantiation of this class.
   */
  private ErrorResolverConstants() {
  }

}
