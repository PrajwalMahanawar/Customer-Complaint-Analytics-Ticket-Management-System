package com.prajwal.complaints.service;

import com.prajwal.complaints.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final TicketRepository ticketRepository;

    public Map<String, Object> getTicketSummary() {

        Map<String, Object> summary = new HashMap<>();

        summary.put("totalTickets", ticketRepository.count());
        summary.put("openTickets", ticketRepository.countByStatus("OPEN"));
        summary.put("inProgressTickets", ticketRepository.countByStatus("IN_PROGRESS"));
        summary.put("resolvedTickets", ticketRepository.countByStatus("RESOLVED"));

        summary.put("highPriorityTickets", ticketRepository.countByPriority("HIGH"));
        summary.put("mediumPriorityTickets", ticketRepository.countByPriority("MEDIUM"));
        summary.put("lowPriorityTickets", ticketRepository.countByPriority("LOW"));

        return summary;
    }
}
