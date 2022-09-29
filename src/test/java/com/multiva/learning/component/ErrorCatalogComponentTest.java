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

package com.multiva.learning.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiva.learning.constant.ConstantsTest;
import com.multiva.learning.constant.ErrorResolverConstants;
import com.multiva.learning.constant.SpecialCharacterConstants;
import com.multiva.learning.entity.ErrorCatalog;
import com.multiva.learning.repository.ErrorCatalogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * class to test ErrorCatalogComponent to validate business logic.
 *
 * @author Empresa.
 */
@SpringBootTest
public class ErrorCatalogComponentTest {

  /**
   * ErrorCatalogComponent as mock.
   */
  @InjectMocks
  private ErrorCatalogComponent catalogComponent;

  /**
   * ErrorCatalogRepository as mock.
   */
  @Mock
  private ErrorCatalogRepository catalogRepository;

  /**
   * ErrorResolverConstants as mock.
   */
  @Mock
  private ErrorResolverConstants errorResolver;

  /**
   * ErrorCatalog as mock.
   */
  private ErrorCatalog errorCatalog;

  /**
   * Initializing Mockito annotations for this test class and objects.
   */
  @BeforeEach
  void setUp() throws IOException {
    MockitoAnnotations.openMocks(this);

    ObjectMapper objectMapper = new ObjectMapper();
    ClassLoader classLoader = getClass().getClassLoader();

    errorCatalog = objectMapper.readValue(
        new File(classLoader.getResource(ConstantsTest.ERROR_CATALOG).getFile()),
        ErrorCatalog.class);
  }

  /**
   * Makes a validations for catalogComponent.errorBusinessValidation() and test failed.
   *
   * Given the next values prefix, modulo, codeError, language and medEnt.
   * When catalogRepository.findByPrefixAndModuloAndCodeErrorAndLanguageAndMedEnt() is invoked
   * and return an object of type ErrorCatalog.
   * Then return a string with message of error the exception.
   */
  @Test
  void errorBusinessValidationTest() {
    Mockito.when(catalogRepository.findByPrefixAndModuleAndMnsOrgAndLanguageAndMedEnt(
        Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(),
        Mockito.anyInt())).thenReturn(errorCatalog);

    Assertions.assertNotNull(catalogComponent.errorBusinessValidation(
        SpecialCharacterConstants.VALUE_INT_5, ConstantsTest.EN_ES, ConstantsTest.STRING_VALUE_8));
  }

  /**
   * Makes a validations for catalogComponent.errorBusinessValidation() and test failed.
   *
   * Given the next values prefix, modulo, codeError, language and medEnt.
   * When catalogRepository.findByPrefixAndModuloAndCodeErrorAndLanguageAndMedEnt() is invoked
   * and return an object null.
   * Then return an exception the type IllegalArgumentException.
   */
  @Test
  void errorBusinessValidationExTest() {
    Mockito.when(catalogRepository.findByPrefixAndModuleAndMnsOrgAndLanguageAndMedEnt(
        Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(),
        Mockito.anyInt())).thenReturn(null);

    Assertions.assertThrows(IllegalArgumentException.class,
        () -> catalogComponent.errorBusinessValidation(
            SpecialCharacterConstants.VALUE_INT_5, ConstantsTest.EN_ES,
            ConstantsTest.STRING_VALUE_8));
  }

}
