package com.prajwal.complaints.repository;

import com.prajwal.complaints.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatus(String status);

    List<Ticket> findByPriority(String priority);

    List<Ticket> findByCategory(String category);

    long countByStatus(String status);

    long countByPriority(String priority);

    long countByCategory(String category);
}