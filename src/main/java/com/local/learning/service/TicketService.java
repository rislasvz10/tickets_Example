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

package com.local.learning.service;

import com.local.learning.model.TicketRequest;
import com.multiva.learning.model.TicketResponse;
import java.util.List;

/**
 * Interface to do the contract.
 */
public interface TicketService {

  /**
   * This method is used to create a registry of the ticket.
   *
   * @param request of type TicketRequest.
   * @return an object of type TicketResponse.
   */
  TicketResponse createTicket(TicketRequest request);

  /**
   * This method is used to find a registry.
   *
   * @param id of type Integer.
   * @return an object of type ticketResponse.
   */
  TicketResponse findTicketById(Integer id);

  /**
   * This method is used to return all tickets.
   *
   * @return a list of tickets.
   */
  List<TicketResponse> getTickets();

}
