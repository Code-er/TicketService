package com.cg.omts.Validation;

public class OmtsValidation {
	
	public boolean isValidTicketId(int ticketId){
        if(ticketId >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
	
	public boolean isValidNumberOfSeats(int numberOfSeats){
        if(numberOfSeats >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isValidSeatName(String seatName){
        if(seatName == null|| seatName == "") {
        	return false;
        }
        else {
        	return true;
        }
    }
    
	public boolean isValidBookingRef(int bookingRef){
        if(bookingRef >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isValidScreenName(String screenName){
        if(screenName == null || screenName == "") {
        	return false;
        }
        else {
        	return true;
        }
    }
}
