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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * Api Constants class for Controller class.
 *
 * @author Empresa.
 */
@Component
@EnableConfigurationProperties
@Getter
public class ApiConstants {

  /**
   * Api operation.
   */
  public static final String OPERATION_API = "API orchestration for Early validation";

  /**
   * Constant that is used to show a message about an OK.
   */
  public static final String OK = "OK";

  /**
   * Constant that is used to show a message about an Bad request.
   */
  public static final String BAD_REQUEST = "Bad Request";

  /**
   * Constant that is used to show a message about an Internal server error.
   */
  public static final String INTERNAL_ERROR = "Internal server error";

  /**
   * Constant used to represent the header name of Content-Type.
   */
  public static final String CONTENT_TYPE = "Content-Type";

  /**
   * Constant used to represent the header name of Accept.
   */
  public static final String ACCEPT = "Accept";

  /**
   * Constant used to represent the header name of sid.
   */
  public static final String SID = "sid";

  /**
   * Constant used to represent the header name of uuid.
   */
  public static final String UUID = "uuid";

  /**
   * Constant used to represent the header name of ChannelId.
   */
  public static final String CHANNEL_ID = "ChannelId";

  /**
   * Constant used to represent the header name of Authorization.
   */
  public static final String AUTHORIZATION = "Authorization";

  /**
   * Constant used to represent the header name of client_id.
   */
  public static final String CLIENT_ID = "client_id";

  /**
   * Constant used to represent the header name of country_code.
   */
  public static final String COUNTRY_CODE = "countryCode";

  /**
   * Constant used to represent the header name of businesscode.
   */
  public static final String BUSINESS_CODE = "businessCode";

  /**
   * Constant used to represent the header name of Accept-Language.
   */
  public static final String ACCEPT_LANGUAGE = "Accept-Language";

  /**
   * Constant that is used to show the status code 200.
   */
  public static final int CODE_OK = 200;

  /**
   * Constant that is used to show the status code 400.
   */
  public static final int CODE_BAD_REQUEST = 400;

  /**
   * Constant that is used to show the status code 500.
   */
  public static final int CODE_INTERNAL_ERROR = 500;

  /**
   * Regex validation expression for application/json value.
   */
  public static final String REGEX = "(?i)" + MediaType.APPLICATION_JSON_VALUE + "|(?i)"
      + MediaType.APPLICATION_JSON_VALUE + "(;charset=+.*)*";

  /**
   * Regex message displayed when Accept header validation fails.
   */
  public static final String REGEX_MSG = "Accept header is wrong, must be "
      + MediaType.APPLICATION_JSON_VALUE + " or " + MediaType.APPLICATION_JSON_VALUE + ";charset=*";

  /**
   * Private constructor will prevent the instantiation of this class.
   */
  private ApiConstants() {
  }

}
