package com.prajwal.complaints.service;

import com.prajwal.complaints.dto.CommentRequest;
import com.prajwal.complaints.dto.TicketRequest;
import com.prajwal.complaints.entity.Ticket;
import com.prajwal.complaints.entity.TicketComment;
import com.prajwal.complaints.repository.TicketCommentRepository;
import com.prajwal.complaints.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketCommentRepository ticketCommentRepository;

    public Ticket createTicket(TicketRequest request) {

        Ticket ticket = Ticket.builder()
                .customerName(request.getCustomerName())
                .customerEmail(request.getCustomerEmail())
                .category(request.getCategory())
                .subject(request.getSubject())
                .description(request.getDescription())
                .priority(assignPriority(request.getCategory(), request.getDescription()))
                .status("OPEN")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket updateStatus(Long id, String status) {
        Ticket ticket = getTicketById(id);

        ticket.setStatus(status);
        ticket.setUpdatedAt(LocalDateTime.now());

        if (status.equalsIgnoreCase("RESOLVED")) {
            ticket.setResolvedAt(LocalDateTime.now());
        }

        return ticketRepository.save(ticket);
    }

    public TicketComment addComment(Long ticketId, CommentRequest request) {

        getTicketById(ticketId);

        TicketComment comment = TicketComment.builder()
                .ticketId(ticketId)
                .analystName(request.getAnalystName())
                .comment(request.getComment())
                .createdAt(LocalDateTime.now())
                .build();

        return ticketCommentRepository.save(comment);
    }

    public List<TicketComment> getComments(Long ticketId) {
        return ticketCommentRepository.findByTicketId(ticketId);
    }

    private String assignPriority(String category, String description) {

        String text = (category + " " + description).toLowerCase();

        if (text.contains("fraud") || text.contains("unauthorized") || text.contains("account locked")) {
            return "HIGH";
        }

        if (text.contains("payment") || text.contains("refund") || text.contains("transaction")) {
            return "MEDIUM";
        }

        return "LOW";
    }
}