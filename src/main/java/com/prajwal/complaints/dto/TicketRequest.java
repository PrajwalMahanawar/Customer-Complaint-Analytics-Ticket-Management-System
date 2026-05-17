package com.prajwal.complaints.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {
    private String customerName;
    private String customerEmail;
    private String category;
    private String subject;
    private String description;
}
