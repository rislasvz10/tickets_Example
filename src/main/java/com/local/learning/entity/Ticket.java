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

package com.local.learning.entity;

import com.local.learning.constant.DomainConstants;
import com.local.learning.model.TicketRequest;
import com.multiva.learning.util.Util;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ticket class.
 *
 * @author Empresa.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DomainConstants.TABLE_TICKET)
public class Ticket {

  /**
   * Field of type Integer.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = DomainConstants.ID)
  private Integer id;

  /**
   * Field of type LocalDate.
   */
  @Column(name = DomainConstants.FECHA_SALIDA)
  private LocalDate fechaSalida;

  /**
   * Field of type LocalDate.
   */
  @Column(name = DomainConstants.FECHA_LLEGADA)
  private LocalDate fechaLlegada;

  /**
   * Field of type String.
   */
  @Column(name = DomainConstants.ORIGEN)
  private String origen;

  /**
   * Field of type String.
   */
  @Column(name = DomainConstants.DESTINO)
  private String destino;

  /**
   * Field of type String.
   */
  @Column(name = DomainConstants.NOMBRE)
  private String nombre;

  /**
   * Field of type Integer.
   */
  @Column(name = DomainConstants.EDAD)
  private Integer edad;

  /**
   * Field of type Boolean.
   */
  @Column(name = DomainConstants.EQUIPAJE)
  private Boolean equipaje;

  /**
   * Field of type Double.
   */
  @Column(name = DomainConstants.PRECIO)
  private Double precio;

  /**
   * Field of type LocalTime.
   */
  @Column(name = DomainConstants.HORA_SALIDA)
  private LocalTime horaSalida;

  /**
   * Field of type LocalTime.
   */
  @Column(name = DomainConstants.HORA_LLEGADA)
  private LocalTime horaLlegada;

  /**
   * Constructor used to initiate the values of class with request.
   *
   * @param request of type TicketRequest.
   */
  public Ticket(TicketRequest request) {
    this.fechaSalida = Util.stringToLocalDate(request.getFechaSalida());
    this.fechaLlegada = Util.stringToLocalDate(request.getFechaLlegada());
    this.origen = request.getOrigen();
    this.destino = request.getDestino();
    this.nombre = request.getNombre();
    this.edad = request.getEdad();
    this.equipaje = request.getEquipaje();
    this.precio = request.getPrecio();
    this.horaSalida = Util.stringToLocalTime(request.getHoraSalida());
    this.horaLlegada = Util.stringToLocalTime(request.getHoraLlegada());
  }

}
