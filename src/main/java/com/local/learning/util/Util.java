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

package com.local.learning.util;

import com.local.learning.constant.Constants;
import com.local.learning.constant.SpecialCharacterConstants;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * Util class.
 *
 * @author Empresa.
 */
public class Util {

  /**
   * Private Constructor will prevent the instantiation of this class directly.
   */
  private Util() {
  }

  /**
   * This method convert a string to LocalDate.
   *
   * @param date of type String.
   * @return a LocalDate.
   */
  public static LocalDate stringToLocalDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
        SpecialCharacterConstants.FORMAT_DATE);
    return LocalDate.parse(date, formatter);
  }

  /**
   * This method convert a string to LocalTime.
   *
   * @param date of type String.
   * @return a LocalDate.
   */
  public static LocalTime stringToLocalTime(String date) {
    return LocalTime.parse(date);
  }

  /**
   * Validates the language in spanish or english.
   *
   * @param lang a String object.
   * @return an integer value that defines the language 1 or 0.
   */
  public static int validateLanguage(String lang) {
    int languageCode = SpecialCharacterConstants.VALUE_INT_1;

    if (Objects.nonNull(lang) && lang.equals(Constants.EN_US)) {
      languageCode = SpecialCharacterConstants.VALUE_INT_2;
    }
    return languageCode;
  }

  /**
   * This method validate the input channel.
   *
   * @param mendEnt a Integer object.
   * @return an integer value that defines the language 1 or 0.
   */
  public static int validateMedEnt(Integer mendEnt) {
    return ObjectUtils.isEmpty(mendEnt) ? SpecialCharacterConstants.VALUE_INT_30 : mendEnt;
  }

  /**
   * This method add zeros a left.
   *
   * @param cad a String object.
   * @return the string of error in four digits.
   */
  public static String addZeros(String cad) {
    return StringUtils.leftPad(cad, SpecialCharacterConstants.VALUE_INT_4,
        SpecialCharacterConstants.VALUE_STRING_0);
  }

}
