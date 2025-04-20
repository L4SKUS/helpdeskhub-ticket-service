package com.helpdeskhub.tickets.mapper;

import com.helpdeskhub.tickets.dto.TicketCreateDTO;
import com.helpdeskhub.tickets.dto.TicketResponseDTO;
import com.helpdeskhub.tickets.dto.TicketUpdateDTO;
import com.helpdeskhub.tickets.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketMapper {

    public Ticket toTicket(TicketCreateDTO dto) {
        return Ticket.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .priority(dto.getPriority())
                .customerId(dto.getCustomerId())
                .agentId(dto.getAgentId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public TicketResponseDTO toTicketResponseDTO(Ticket ticket) {
        return TicketResponseDTO.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(ticket.getPriority())
                .customerId(ticket.getCustomerId())
                .agentId(ticket.getAgentId())
                .createdAt(ticket.getCreatedAt())
                .updatedAt(ticket.getUpdatedAt())
                .build();
    }

    public void updateTicketFromDTO(Ticket ticket, TicketUpdateDTO dto) {
        if (dto.getStatus() != null) {
            ticket.setStatus(dto.getStatus());
        }
        if (dto.getPriority() != null) {
            ticket.setPriority(dto.getPriority());
        }
        if (dto.getAgentId() != null) {
            ticket.setAgentId(dto.getAgentId());
        }
        ticket.setUpdatedAt(LocalDateTime.now());
    }
}
