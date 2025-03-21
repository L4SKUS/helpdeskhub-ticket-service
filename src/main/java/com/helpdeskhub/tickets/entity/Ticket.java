package com.helpdeskhub.tickets;

import com.helpdeskhub.tickets.enums.TicketPriority;
import com.helpdeskhub.tickets.enums.TicketStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Ticket {

    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    private String createdBy;
    private String assignedTo;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Ticket(String title, String description, TicketStatus status, TicketPriority priority,
                  String createdBy, String assignedTo, Timestamp createdAt, Timestamp updatedAt) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
