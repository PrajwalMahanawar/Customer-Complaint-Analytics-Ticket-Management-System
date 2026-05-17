package com.prajwal.complaints.controller;

import com.prajwal.complaints.dto.StatusUpdateRequest;
import com.prajwal.complaints.dto.TicketRequest;
import com.prajwal.complaints.entity.Ticket;
import com.prajwal.complaints.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody TicketRequest request) {
        return ticketService.createTicket(request);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/{id}/status")
    public Ticket updateStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateRequest request
    ) {
        return ticketService.updateStatus(id, request.getStatus());
    }
}