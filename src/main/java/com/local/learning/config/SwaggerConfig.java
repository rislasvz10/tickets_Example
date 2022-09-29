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

package com.local.learning.config;

import com.multiva.learning.constant.SpecialCharacterConstants;
import com.multiva.learning.constant.SwaggerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * This class is used to configuration of swagger.
 *
 * @author Empresa.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * This method is used to config the initial values in swagger.
   *
   * @return Docket of type Docket.
   */
  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select().apis(RequestHandlerSelectors.basePackage(SwaggerConstants.PACKAGE))
        .paths(PathSelectors.any()).build().apiInfo(getApiInfo());
  }

  /**
   * This method is used to config the values contact of developer or TL.
   *
   * @return ApiInfo of type ApiInfo.
   */
  private ApiInfo getApiInfo() {
    return new ApiInfo(SwaggerConstants.TITLE, SwaggerConstants.DESC,
        SwaggerConstants.VERSION, SpecialCharacterConstants.EMPTY_STRING,
        new Contact(SwaggerConstants.DEVELOPER_NAME, SwaggerConstants.URL,
            SwaggerConstants.EMAIL_DEVELOPER),
        SwaggerConstants.LICENSE, SwaggerConstants.URL,
        Collections.emptyList()
    );
  }

}
