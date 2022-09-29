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

/**
 * MessagesConstants class to add expressions regular.
 *
 * @author Empresa.
 */
public class MessagesConstants {

  /**
   * Regular expression for values from 00 to 99.
   */
  public static final String REGEX_FOR_REPRESENTATIVE = "[0-9]{2}";

  /**
   * Regular expression for values 0 or 1.
   */
  public static final String REGEX_FROM_AUTHORIZATION_INDICATOR = "0|1{1}";

  /**
   * Regular expression for values numeric integer.
   */
  public static final String REGEX_FROM_CUSTOMER_ID = "[0-9]{1,12}";

  /**
   * Message for empty values or null.
   */
  public static final String MUST_NOT_BE_EMPTY_OR_NULL = "Must not be empty or null";

  /**
   * Message for specific range of size in strings.
   */
  public static final String MUST_BE_INTEGER_NUMERIC_FROM_X_TO_X_DIGITS =
      "Must be integer numeric from {min} to {max} digits";

  /**
   * Message for specific size in a strings.
   */
  public static final String CANT_BE_LARGER_THAN_X_CHARACTERS =
      "Can't be larger than {max} characters";

  /**
   * Message for values from 01 to 99.
   */
  public static final String MUST_BE_FROM_01_TO_99 = "Must be 01 to 99";

  /**
   * Message for values from 01 to 99.
   */
  public static final String MUST_BE_FROM_00_TO_99 = "Must be 00 to 99";

  /**
   * Message for values 0 or 1.
   */
  public static final String MUST_BE_0_OR_1 = "Must be 0 or 1";

  /**
   * Message for validation a numeric integer values.
   */
  public static final String MUST_BE_INTEGER_NUMERIC = "Must be integer numeric";

  /**
   * Message for log of representative validation.
   */
  public static final String REPRESENTATIVE_VALIDATION = "Representative validation {}";

  /**
   * Message for log of payroll validation.
   */
  public static final String PAYROLL_VALIDATION = "Payroll validation {}";

  /**
   * Message for log of payroll validation.
   */
  public static final String TEF_ACCOUNT_VALIDATION = "tef Account Validation {}";

  /**
   * Message for log of Charge account validation.
   */
  public static final String CHARGE_ACCOUNT_VALIDATION = "Charge Account Validation {}";


  /**
   * Private constructor will prevent the instantiation of this class.
   */
  private MessagesConstants() {
  }
}
