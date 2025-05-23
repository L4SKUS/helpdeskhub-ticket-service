package com.helpdeskhub.tickets.service;

import com.helpdeskhub.tickets.dto.TicketCreateDTO;
import com.helpdeskhub.tickets.dto.TicketResponseDTO;
import com.helpdeskhub.tickets.dto.TicketUpdateDTO;
import com.helpdeskhub.tickets.mapper.TicketMapper;
import com.helpdeskhub.tickets.model.Ticket;
import com.helpdeskhub.tickets.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketResponseDTO createTicket(TicketCreateDTO dto) {
        Ticket newTicket = ticketMapper.toTicket(dto);
        Ticket savedTicket = ticketRepository.save(newTicket);
        return ticketMapper.toTicketResponseDTO(savedTicket);
    }

    public List<TicketResponseDTO> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(ticketMapper::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    public TicketResponseDTO getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId)
                .map(ticketMapper::toTicketResponseDTO)
                .orElseThrow(() -> new IllegalStateException("Ticket not found with id: " + ticketId));
    }

    public List<TicketResponseDTO> getTicketsByCustomerId(Integer customerId) {
        return ticketRepository.findAllByCustomerId(customerId)
                .stream()
                .map(ticketMapper::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TicketResponseDTO> getTicketsByAgentId(Integer agentId) {
        return ticketRepository.findAllByAgentId(agentId)
                .stream()
                .map(ticketMapper::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteTicket(Integer ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            throw new IllegalStateException("Ticket not found with id: " + ticketId);
        }
        ticketRepository.deleteById(ticketId);
    }

    public TicketResponseDTO updateTicket(Integer ticketId, TicketUpdateDTO dto) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalStateException("Ticket not found with id: " + ticketId));

        ticketMapper.updateTicketFromDTO(ticket, dto);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toTicketResponseDTO(updatedTicket);
    }
}