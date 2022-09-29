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

package com.multiva.learning.util;

import com.multiva.learning.constant.ConstantsTest;
import com.multiva.learning.constant.SpecialCharacterConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UtilTest class to validate utilities.
 *
 * @author Empresa
 */
@SpringBootTest
public class UtilTest {

  /**
   * Make the validation of method stringToLocalTime().
   *
   * Given a string with an hour in format hh:mm.
   * When Utils.stringToLocalTime() is invoked.
   * Then return an object of type LocalTime.
   */
  @Test
  void StringToLocalTimeTest() {
    Assertions.assertNotNull(Util.stringToLocalTime(ConstantsTest.TIME_TEST));
  }

  /**
   * Make the validation of method stringToLocalDate().
   *
   * Given a string with an hour in format hh:mm.
   * When Utils.stringToLocalDate() is invoked.
   * Then return an object of type LocalDate.
   */
  @Test
  void StringToLocalDate() {
    Assertions.assertNotNull(Util.stringToLocalDate(ConstantsTest.DATE_TEST));
  }

  /**
   * Makes a validations for Util.validateLanguage() and test fail.
   *
   * Given a String as Json and Type reference for this json.
   * When Util.getPojo() is invoked.
   * Then return a null.
   */
  @Test
  void validateLanguageTestSp() {
    Assertions.assertEquals(SpecialCharacterConstants.VALUE_INT_1,
        Util.validateLanguage(ConstantsTest.EN_ES));
  }

  /**
   * Makes a validations for Util.validateLanguage() and test success.
   *
   * Given a String as language.
   * When Util.validateLanguage() is invoked.
   * Then return an int value as language code.
   */
  @Test
  void validateLanguageTestEn() {
    Assertions.assertEquals(SpecialCharacterConstants.VALUE_INT_2,
        Util.validateLanguage(ConstantsTest.EN_US));
  }

  /**
   * Makes a validations for Util.validateLanguage() and test success.
   *
   * Given a String as language.
   * When Util.validateLanguage() is invoked.
   * Then return an int value as language code.
   */
  @Test
  void validateLanguageTestNull() {
    Assertions.assertEquals(SpecialCharacterConstants.VALUE_INT_1, Util.validateLanguage(null));
  }


  /**
   * Makes a validations for Util.validateMedEnt() and test success.
   *
   * Given a Integer as channel.
   * When Util.validateMedEnt() is invoked.
   * Then return a int value as channel default for errors.
   */
  @Test
  void validateMedEntTest() {
    Assertions.assertEquals(SpecialCharacterConstants.VALUE_INT_30,
        Util.validateMedEnt(SpecialCharacterConstants.VALUE_INT_30));
  }

  /**
   * Makes a validations for Util.validateMedEnt() and test success.
   *
   * Given a Integer as channel.
   * When Util.validateMedEnt() is invoked.
   * Then return a int value as channel default for errors.
   */
  @Test
  void validateMedEntTestNull() {
    Assertions.assertEquals(SpecialCharacterConstants.VALUE_INT_30,
        Util.validateMedEnt(null));
  }

  /**
   * Makes a validations for Util.addZeros() and test success.
   *
   * Given a value to add zeros.
   * When Util.addZeros() is invoked.
   * Then return a value with length 4 digits.
   */
  @Test
  public void addZerosTest() {
    Assertions.assertNotNull(Util.addZeros(SpecialCharacterConstants.VALUE_STRING_11));
  }

}
