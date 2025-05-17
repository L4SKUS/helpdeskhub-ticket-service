package com.helpdeskhub.tickets.config;

import com.helpdeskhub.tickets.model.Ticket;
import com.helpdeskhub.tickets.enums.TicketPriority;
import com.helpdeskhub.tickets.enums.TicketStatus;
import com.helpdeskhub.tickets.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class TicketConfig {

    @Bean
    CommandLineRunner commandLineRunner(TicketRepository repository) {
        return args -> {
            Ticket ticket1 = Ticket.builder()
                    .title("Laptop repair")
                    .description("Laptop doesn't work")
                    .status(TicketStatus.OPEN)
                    .priority(TicketPriority.HIGH)
                    .customerId(1)
                    .agentId(57)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Ticket ticket2 = Ticket.builder()
                    .title("Monitor repair")
                    .description("Monitor doesn't work")
                    .status(TicketStatus.OPEN)
                    .priority(TicketPriority.LOW)
                    .customerId(34)
                    .agentId(5)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Ticket ticket3 = Ticket.builder()
                    .title("Lost mouse")
                    .description("Mouse is lost")
                    .status(TicketStatus.OPEN)
                    .priority(TicketPriority.HIGH)
                    .customerId(1)
                    .agentId(1)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            repository.saveAll(List.of(ticket1, ticket2, ticket3));
        };
    }
}
