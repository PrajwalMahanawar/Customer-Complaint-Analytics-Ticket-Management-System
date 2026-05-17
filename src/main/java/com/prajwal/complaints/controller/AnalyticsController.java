package com.prajwal.complaints.controller;

import com.prajwal.complaints.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return analyticsService.getTicketSummary();
    }
}