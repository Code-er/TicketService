package com.cg.omts.Service;

import java.util.List;

import com.cg.omts.Entity.Ticket;

public interface TicketService {
	public Ticket generateTicket(Ticket ticket);
	public List<Ticket> getTicket();
	public Ticket getTicketById(Integer ticketId);
	public Ticket getTicketByBookingId(Integer bookingId);
	public Ticket cancelTicketByTicket(Ticket ticket);
}
