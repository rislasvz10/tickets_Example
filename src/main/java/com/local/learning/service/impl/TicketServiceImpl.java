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

package com.local.learning.service.impl;

import com.local.learning.component.ErrorCatalogComponent;
import com.local.learning.constant.Constants;
import com.local.learning.constant.SpecialCharacterConstants;
import com.local.learning.entity.Ticket;
import com.local.learning.model.TicketRequest;
import com.local.learning.repository.TicketRepository;
import com.local.learning.service.TicketService;
import com.multiva.learning.model.TicketResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class to implement the business logic.
 *
 * @author Empresa.
 */
@Service
public class TicketServiceImpl implements TicketService {

  /**
   * component to communication with the db.
   */
  @Autowired
  private TicketRepository ticketRepository;

  @Autowired
  private ErrorCatalogComponent errorCatalogComponent;

  /**
   * {@inheritDoc}.
   */
  @Override
  public TicketResponse createTicket(TicketRequest request) {
    Ticket ticket = ticketRepository.save(new Ticket(request));
    return new TicketResponse(ticket);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public TicketResponse findTicketById(Integer id) {
    Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
        errorCatalogComponent.errorBusinessValidation(SpecialCharacterConstants.VALUE_INT_5,
            Constants.EN_US, SpecialCharacterConstants.VALUE_STRING_1)));
    return new TicketResponse(ticket);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<TicketResponse> getTickets() {
    List<Ticket> tickets = ticketRepository.findAll();
    if (tickets.isEmpty()) {
      throw new IllegalArgumentException(
          errorCatalogComponent.errorBusinessValidation(SpecialCharacterConstants.VALUE_INT_5,
              Constants.EN_US, SpecialCharacterConstants.VALUE_STRING_1));
    }

    return tickets.stream().map(TicketResponse::new).collect(Collectors.toList());
  }
}
