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

package com.multiva.learning.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiva.learning.component.ErrorCatalogComponent;
import com.multiva.learning.constant.ConstantsTest;
import com.multiva.learning.entity.Ticket;
import com.multiva.learning.model.TicketRequest;
import com.multiva.learning.repository.TicketRepository;
import com.multiva.learning.service.impl.TicketServiceImpl;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * class to test TicketServiceImpl to validate business logic.
 *
 * @author Empresa.
 */
@SpringBootTest
public class TicketServiceImplTest {

  /**
   * TicketServiceImpl as mock for test.
   */
  @InjectMocks
  private TicketServiceImpl ticketService;

  /**
   * TicketRepository as mock.
   */
  @Mock
  private TicketRepository ticketRepository;

  /**
   * ErrorResolverConstants as mock.
   */
  @Mock
  private ErrorCatalogComponent errorCatalogComponent;

  /**
   * TicketRequest as mock.
   */
  private TicketRequest request;

  /**
   * Initializing Mockito annotations for this test class and objects.
   */
  @BeforeEach
  void setUp() throws IOException {
    MockitoAnnotations.openMocks(this);

    ObjectMapper objectMapper = new ObjectMapper();
    ClassLoader classLoader = getClass().getClassLoader();

    request = objectMapper.readValue(
        new File(classLoader.getResource(ConstantsTest.TICKET_REQUEST).getFile()),
        TicketRequest.class);
  }

  /**
   * Makes a validations for ticketService.getTickets() and test failed.
   *
   * Given a request with values of user to create an object.
   * When ticketRepository.save() is invoked.
   * Then return an object of type TicketResponse.
   */
  @Test
  void createTicketTest() {
    Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(new Ticket());
    Assertions.assertNotNull(ticketService.createTicket(request));
  }

  /**
   * Makes a validations for ticketService.getTickets() and test failed.
   *
   * Given a value int.
   * When ticketRepository.findById() is invoked.
   * Then return an exception the type IllegalArgumentException.
   */
  @Test
  void findTicketByIdExTest() {
    Optional<Ticket> optionalTicket = Optional.ofNullable(null);
    Mockito.when(ticketRepository.findById(Mockito.anyInt())).thenReturn(optionalTicket);
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> ticketService.findTicketById(ConstantsTest.INT_VALUE_8));
  }

  /**
   * Makes a validations for ticketService.getTickets() and test failed.
   *
   * Given a value int.
   * When ticketRepository.findById() is invoked.
   * Then return an object of type TicketResponse.
   */
  @Test
  void findTicketByIdTest() {
    Optional<Ticket> optionalTicket = Optional.of(new Ticket());
    Mockito.when(ticketRepository.findById(Mockito.anyInt())).thenReturn(optionalTicket);
    Assertions.assertNotNull(ticketService.findTicketById(ConstantsTest.INT_VALUE_8));
  }

  /**
   * Makes a validations for ticketService.getTickets() and test failed.
   *
   * Given without request.
   * When ticketRepository.findAll() is invoked.
   * Then return a list with objects of type Tickets.
   */
  @Test
  void getTicketsTest() {
    List<Ticket> tickets = new ArrayList<>();
    tickets.add(new Ticket());
    Mockito.when(ticketRepository.findAll()).thenReturn(tickets);
    Assertions.assertNotNull(ticketService.getTickets());
  }

  /**
   * Makes a validations for ticketService.getTickets() and test failed.
   *
   * Given without request.
   * When ticketRepository.findAll() is invoked.
   * Then return an exception the type IllegalArgumentException.
   */
  @Test
  void getTicketsExTest() {
    List<Ticket> tickets = new ArrayList<>();
    Mockito.when(ticketRepository.findAll()).thenReturn(tickets);
    Assertions.assertThrows(IllegalArgumentException.class, () -> ticketService.getTickets());
  }

}
