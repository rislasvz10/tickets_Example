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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.local.learning.constant.Constants;
import com.local.learning.constant.SpecialCharacterConstants;
import java.time.ZonedDateTime;
import lombok.Data;
import org.springframework.util.ObjectUtils;

/**
 * Structure to response an error.
 *
 * @author Empresa.
 */
@Data
public class ErrorResponse {

  /**
   * Type of the error.
   */
  private String type;

  /**
   * Code of the error.
   */
  private String code;

  /**
   * Detail of the error.
   */
  private String details;

  /**
   * Location of the error.
   */
  private String location;

  /**
   * Additional information of the error.
   */
  private String moreInfo;

  /**
   * UUID header from the request.
   */
  private String uuid;

  /**
   * Time when the error occurred.
   */
  private ZonedDateTime timestamp;

  /**
   * Method to get the type of the error.
   */
  public String getType() {
    return !ObjectUtils.isEmpty(type) ? type : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get the code of the error.
   */
  public String getCode() {
    return !ObjectUtils.isEmpty(code) ? code : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get the detail of the error.
   */
  public String getDetails() {
    return !ObjectUtils.isEmpty(details) ? details : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get the location of the error.
   */
  public String getLocation() {
    return !ObjectUtils.isEmpty(location) ? location : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get additional information of the error.
   */
  public String getMoreInfo() {
    return !ObjectUtils.isEmpty(moreInfo) ? moreInfo : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get the UUID.
   */
  public String getUuid() {
    return !ObjectUtils.isEmpty(uuid) ? uuid : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Method to get the time when the error occurred with the format yyyy-MM-dd'T'HH:mm:ssZ.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

}
