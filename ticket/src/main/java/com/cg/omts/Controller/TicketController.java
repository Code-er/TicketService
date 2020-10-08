package com.cg.omts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omts.Entity.Ticket;
import com.cg.omts.Service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/generateTicket")
	public ResponseEntity<Ticket> generateTicket(@RequestBody Ticket ticket) {
		Ticket generatedTicket = ticketService.generateTicket(ticket);
		ResponseEntity<Ticket> response = new ResponseEntity<>(generatedTicket, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value = "/ticketList")
	public List<Ticket> getTicket() {
		List<Ticket> ticketList = null;
		ticketList = ticketService.getTicket();
		return ticketList;
	}
	
	@GetMapping(value = "/ticketId/{ticketId}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Integer ticketId) {
		Ticket ticket = ticketService.getTicketById(ticketId);
		ResponseEntity<Ticket> response = new ResponseEntity<>(ticket, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value = "/bookingId/{bookingId}")
	public ResponseEntity<Ticket> getTicketByBookingId(@PathVariable Integer bookingId) {
		Ticket ticket = ticketService.getTicketByBookingId(bookingId);
		ResponseEntity<Ticket> response = new ResponseEntity<>(ticket, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value = "/cancelTicketId/{ticketId}")
	public ResponseEntity<Ticket> cancelTicketByTicketId(@PathVariable Integer ticketId) {
		Ticket ticket = ticketService.getTicketById(ticketId);
		if(ticket != null) {
			ticket.setTicketStatus(false);
			ticketService.cancelTicketByTicket(ticket);
			ResponseEntity<Ticket> response = new ResponseEntity<>(ticket, HttpStatus.OK);
			return response;
		}
		return null;
	}
	
	@GetMapping(value = "/cancelBookingId/{bookingId}")
	public ResponseEntity<Ticket> cancelTicketByBookingId(@PathVariable Integer bookingId) {
		Ticket ticket = ticketService.getTicketByBookingId(bookingId);
		if(ticket != null) {
			ticket.setTicketStatus(false);
			ticketService.cancelTicketByTicket(ticket);
			ResponseEntity<Ticket> response = new ResponseEntity<>(ticket, HttpStatus.OK);
			return response;
		}
		return null;
	}
}
