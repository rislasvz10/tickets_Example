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

package com.multiva.learning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiva.learning.constant.ConstantsTest;
import com.multiva.learning.model.TicketRequest;
import com.multiva.learning.model.TicketResponse;
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

/**
 * Transfer controller test class.
 *
 * @author Empresa.
 */
@SpringBootTest
public class TicketControllerTest {

  /**
   * TicketController as mock.
   */
  @InjectMocks
  private TicketController controller;

  /**
   * TicketServiceImpl as mock.
   */
  @Mock
  private TicketServiceImpl ticketService;

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
   * Make the test for controller class of method saveTicket().
   *
   * Give a new request.
   * When controller.saveTicket() is called.
   * Then return a code 200 as response.
   */
  @Test
  void saveTicketTest() {
    Mockito.when(ticketService.createTicket(Mockito.any())).thenReturn(new TicketResponse());
    Assertions.assertNotNull(controller.saveTicket(request));
  }

  /**
   * Make the test for controller class of method getTicket().
   *
   * Give a new request.
   * When controller.getTicket() is called.
   * Then return a code 200 as response with ResponseEntity.
   */
  @Test
  void getTicketTest() {
    Mockito.when(ticketService.findTicketById(Mockito.anyInt())).thenReturn(new TicketResponse());
    Assertions.assertNotNull(controller.getTicket(ConstantsTest.INT_VALUE_8));
  }


}
