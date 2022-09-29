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

package com.multiva.learning.model;

import com.local.learning.constant.Constants;
import com.local.learning.constant.SpecialCharacterConstants;
import com.local.learning.entity.Ticket;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class TicketResponse {

  /**
   * Field of type Integer.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_1)
  private Integer itineraryId;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_DATE)
  private LocalDate dateLeave;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_DATE)
  private LocalDate dateArrive;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String origen;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String destiny;

  /**
   * Field of type String.
   */
  @ApiModelProperty(example = Constants.TEST_VALUE)
  private String name;

  /**
   * Field of type Integer.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_10)
  private Integer age;

  /**
   * Field of type Boolean.
   */
  @ApiModelProperty(example = Constants.TRUE_VALUE)
  private Boolean equipment;

  /**
   * Field of type Double.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_DOUBLE_PRECIO)
  private Double price;

  /**
   * Field of type LocalTime.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_HOUR)
  private LocalTime timeLeave;

  /**
   * Field of type LocalTime.
   */
  @ApiModelProperty(example = SpecialCharacterConstants.VALUE_STRING_HOUR)
  private LocalTime timeArrive;

  /**
   * Constructor to initialize the properties of class.
   *
   * @param ticket of type Ticket.
   */
  public TicketResponse(Ticket ticket) {
    this.itineraryId = ticket.getId();
    this.dateLeave = ticket.getFechaSalida();
    this.dateArrive = ticket.getFechaLlegada();
    this.origen = ticket.getOrigen();
    this.destiny = ticket.getDestino();
    this.name = ticket.getNombre();
    this.age = ticket.getEdad();
    this.equipment = ticket.getEquipaje();
    this.price = ticket.getPrecio();
    this.timeLeave = ticket.getHoraSalida();
    this.timeArrive = ticket.getHoraLlegada();
  }

}
