package com.cg.omts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.Entity.Ticket;
import com.cg.omts.Exception.CustomException;
import com.cg.omts.dao.TicketRepository;

import com.cg.omts.Validation.OmtsValidation;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepo;
	
	OmtsValidation validate = new OmtsValidation();
	
	@Override
	public Ticket generateTicket(Ticket ticket) {
		try {
			if(!validate.isValidBookingRef(ticket.getBookingId())) {
				throw new CustomException("Wrong Booking Reference Id");
			}
			else if(!validate.isValidNumberOfSeats(ticket.getNoOfSeats())) {
				throw new CustomException("Invalid Number of Seats");
			}
			else if(!validate.isValidSeatName(ticket.getSeatName())){
				throw new CustomException("Invalid Name of Seat");
			}
			else if(!validate.isValidScreenName(ticket.getScreenName())){
				throw new CustomException("Invalid Name of Screen");
			}
			else {
				ticket.setTicketStatus(true);
				return ticketRepo.save(ticket);
			}
		}
		catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<Ticket> getTicket() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket getTicketById(Integer ticketId) {
		if(!validate.isValidTicketId(ticketId)) {
			throw new CustomException("Wrong Ticket Id");
		}
		else {
			Optional<Ticket> response = ticketRepo.findById(ticketId);
			if (response.isPresent()) {
				return response.get();
			}
			else {
				throw new CustomException("No Ticket Found with Ticket ID : "+ticketId);
			}
		}
	}

	@Override
	public Ticket getTicketByBookingId(Integer bookingId) {
		if(!validate.isValidBookingRef(bookingId)) {
			throw new CustomException("Wrong Booking Id");
		}
		else {
			Ticket response = ticketRepo.searchTicketByBookingRef(bookingId);
			if(response == null) {
				throw new CustomException("No Ticket Found with Booking ID : "+bookingId);
			}
			else {
				return response;
			}
		}
		
	}

	@Override
	public Ticket cancelTicketByTicket(Ticket ticket) {
		try {
			return ticketRepo.save(ticket);
		}
		catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
}
