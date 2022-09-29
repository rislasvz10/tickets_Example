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

package com.local.learning.model;

import com.local.learning.constant.Constants;
import com.local.learning.constant.SpecialCharacterConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class of transfer.
 *
 * @author Empresa.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class TicketRequest {

  /**
   * Field of type LocalDate.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_DATE)
  private String fechaSalida;

  /**
   * Field of type LocalDate.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_DATE)
  private String fechaLlegada;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String origen;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String destino;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String nombre;

  /**
   * Field of type Integer.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_10)
  private Integer edad;

  /**
   * Field of type Boolean.
   */
  @ApiModelProperty(example = Constants.TRUE_VALUE)
  private Boolean equipaje;

  /**
   * Field of type Double.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_DOUBLE_PRECIO)
  private Double precio;

  /**
   * Field of type LocalTime.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_HOUR)
  private String horaSalida;

  /**
   * Field of type LocalTime.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_HOUR)
  private String horaLlegada;

}
