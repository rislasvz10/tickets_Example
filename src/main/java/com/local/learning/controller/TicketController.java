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

package com.local.learning.controller;

import com.multiva.learning.model.TicketRequest;
import com.multiva.learning.model.TicketResponse;
import com.multiva.learning.service.TicketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class with entry-point methods for the API's.
 *
 * @author Empresa.
 */
@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TicketController {

  /**
   * Component that contains the business rules.
   */
  @Autowired
  private TicketService ticketService;

  /**
   * This method is used to insert a registry of ticket.
   *
   * @param request of type TicketRequest.
   * @return a ResponseEntity.
   */
  @PostMapping(value = "${constants.api.uri.specificPaths.ticket.insert}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a new ticket.", notes = "Generate a new object in database.")
  public ResponseEntity<Void> saveTicket(@RequestBody TicketRequest request) {
    ticketService.createTicket(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * This method is used to get a ticket.
   *
   * @param id of type Integer.
   * @return a ResponseEntity with a List of TicketResponse in format json.
   */
  @GetMapping(value = "${constants.api.uri.specificPaths.ticket.get}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TicketResponse> getTicket(@RequestParam Integer id) {
    return new ResponseEntity<>(ticketService.findTicketById(id), HttpStatus.OK);
  }

}
