package com.helpdeskhub.tickets.repository;

import com.helpdeskhub.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    //Optional<Ticket> findTicketByCustomerId(Integer customerId);
}
