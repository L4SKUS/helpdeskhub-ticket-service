package com.helpdeskhub.tickets.repository;

import com.helpdeskhub.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByCustomerId(Integer customerId);
    List<Ticket> findAllByAgentId(Integer agentId);
}
