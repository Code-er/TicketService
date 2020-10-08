package com.cg.omts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.omts.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	@Query(value = "Select * from ticket where booking_ref = ? LIMIT 1", nativeQuery = true)
	Ticket searchTicketByBookingRef(Integer bookingId);
}
