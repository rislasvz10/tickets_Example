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

package com.local.learning.component;

import com.multiva.learning.constant.ErrorResolverConstants;
import com.multiva.learning.constant.SpecialCharacterConstants;
import com.multiva.learning.entity.ErrorCatalog;
import com.multiva.learning.repository.ErrorCatalogRepository;
import com.multiva.learning.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * ErrorCatalogComponent class get the error in database to show the user/front end.
 *
 * @author Empresa.
 */
@Component
public class ErrorCatalogComponent {

  /**
   * component to communication with the db.
   */
  @Autowired
  private ErrorCatalogRepository catalogRepository;

  /**
   * component of error messages.
   */
  @Autowired
  private ErrorResolverConstants errorResolver;

  /**
   * Error business validation string.
   *
   * @param error    error code.
   * @param language messages language to response.
   * @param med      channel id.
   * @return the string error.
   */
  public String errorBusinessValidation(int error, String language, String med) {

    int codeLang = Util.validateLanguage(language);

    int medEnt = Util.validateMedEnt(Integer.parseInt(med));

    ErrorCatalog errorCatalog =
        catalogRepository.findByPrefixAndModuleAndMnsOrgAndLanguageAndMedEnt(
        SpecialCharacterConstants.PREFIX, SpecialCharacterConstants.MODULE_003, error, codeLang,
        medEnt);

    if (ObjectUtils.isEmpty(errorCatalog)) {
      throw new IllegalArgumentException(errorResolver.getNotFoundError());
    }

    StringBuilder strBuild = new StringBuilder();
    strBuild.append(errorCatalog.getPrefix());
    strBuild.append(SpecialCharacterConstants.SPACE_STRING);
    strBuild.append(errorCatalog.getModule());
    strBuild.append(SpecialCharacterConstants.SPACE_STRING);
    strBuild.append(Util.addZeros(String.valueOf(errorCatalog.getMnsOrg())));
    strBuild.append(SpecialCharacterConstants.COLON);
    strBuild.append(errorCatalog.getDescription().trim());

    return strBuild.toString();
  }

}
