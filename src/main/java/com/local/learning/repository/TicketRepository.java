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

package com.local.learning.repository;

import com.local.learning.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class to connect the database.
 *
 * @author Empresa.
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
