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
import com.local.learning.constant.SpecialCharacterConstants;
import java.io.Serializable;
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
 * ErrorCatalog class.
 *
 * @author Empresa.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DomainConstants.TABLE_ERROR)
public class ErrorCatalog implements Serializable {

  /**
   * Serial version UID Generic.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Field ID_ERROR.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = DomainConstants.ID_ERROR)
  private Integer idError;

  /**
   * Field PREFIJO.
   */
  @Column(name = DomainConstants.PREFIX)
  private String prefix;

  /**
   * Field MODULO.
   */
  @Column(name = DomainConstants.MODULE)
  private String module;

  /**
   * Field MNS_ORG.
   */
  @Column(name = DomainConstants.MNS_ORG)
  private int mnsOrg;

  /**
   * Field LANGUAGE.
   */
  @Column(name = DomainConstants.LANGUAGE)
  private int language;

  /**
   * Field MED_ENT.
   */
  @Column(name = DomainConstants.MED_ENT)
  private int medEnt;

  /**
   * Field DESCMNS.
   */
  @Column(name = DomainConstants.DESCMNS,
      length = SpecialCharacterConstants.VALUE_INT_80)
  private String description;

}
