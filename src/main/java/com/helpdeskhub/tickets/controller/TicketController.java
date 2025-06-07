package com.helpdeskhub.tickets.controller;

import com.helpdeskhub.tickets.dto.TicketCreateDTO;
import com.helpdeskhub.tickets.dto.TicketResponseDTO;
import com.helpdeskhub.tickets.dto.TicketUpdateDTO;
import com.helpdeskhub.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketCreateDTO dto) {
        TicketResponseDTO createdTicket = ticketService.createTicket(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable Integer ticketId) {
        TicketResponseDTO ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<TicketResponseDTO>> getTicketsByClientId(@PathVariable Integer clientId) {
        List<TicketResponseDTO> tickets = ticketService.getTicketsByClientId(clientId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TicketResponseDTO>> getTicketsByEmployeeId(@PathVariable Integer employeeId) {
        List<TicketResponseDTO> tickets = ticketService.getTicketsByEmployeeId(employeeId);
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDTO> updateTicket(
            @PathVariable Integer ticketId,
            @RequestBody TicketUpdateDTO dto) {
        TicketResponseDTO updatedTicket = ticketService.updateTicket(ticketId, dto);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{ticketId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Integer ticketId) {
        ticketService.deleteTicket(ticketId);
    }
}