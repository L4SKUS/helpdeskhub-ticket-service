package com.helpdeskhub.tickets.dto;

import com.helpdeskhub.tickets.enums.TicketPriority;
import com.helpdeskhub.tickets.enums.TicketStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TicketResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private Integer clientId;
    private Integer employeeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
