package com.prajwal.complaints.controller;

import com.prajwal.complaints.dto.CommentRequest;
import com.prajwal.complaints.entity.TicketComment;
import com.prajwal.complaints.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class CommentController {

    private final TicketService ticketService;

    @PostMapping("/{ticketId}/comments")
    public TicketComment addComment(
            @PathVariable Long ticketId,
            @RequestBody CommentRequest request
    ) {
        return ticketService.addComment(ticketId, request);
    }

    @GetMapping("/{ticketId}/comments")
    public List<TicketComment> getComments(@PathVariable Long ticketId) {
        return ticketService.getComments(ticketId);
    }
}