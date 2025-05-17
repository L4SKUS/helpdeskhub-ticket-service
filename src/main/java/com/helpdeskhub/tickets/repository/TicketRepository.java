package com.helpdeskhub.tickets.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.helpdeskhub.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByCustomerId(Integer customerId);
}
