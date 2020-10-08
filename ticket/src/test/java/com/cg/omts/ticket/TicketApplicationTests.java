package com.cg.omts.ticket;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.omts.Validation.OmtsValidation;

@SpringBootTest
class TicketApplicationTests {

	OmtsValidation validate = new OmtsValidation();
	
	@Test
	void testValidTicketIdForZero() {
		boolean result = validate.isValidTicketId(0);
		assertFalse(result);
	}
	
	@Test
	void testValidTicketIdForNegatives() {
		boolean result = validate.isValidTicketId(-5);
		assertFalse(result);
	}
	
	@Test
	void testValidTicketIdForPositives() {
		boolean result = validate.isValidTicketId(7);
		assertTrue(result);
	}
	
	@Test
	void testValidSeatNumberForZero() {
		boolean result = validate.isValidTicketId(0);
		assertFalse(result);
	}
	
	@Test
	void testValidSeatNumberForNegative() {
		boolean result = validate.isValidTicketId(-3);
		assertFalse(result);
	}
	
	@Test
	void testValidSeatNumberForPositive() {
		boolean result = validate.isValidTicketId(2);
		assertTrue(result);
	}
	
	@Test
	void testValidSeatNameForEmpty() {
		boolean result = validate.isValidSeatName("");
		assertFalse(result);
	}
	
	@Test
	void testValidSeatNameForNull() {
		boolean result = validate.isValidSeatName(null);
		assertFalse(result);
	}
	
	@Test
	void testValidSeatNameForString() {
		boolean result = validate.isValidSeatName("A5");
		assertTrue(result);
	}
	
	@Test
	void testValidBookingRefForZero() {
		boolean result = validate.isValidBookingRef(0);
		assertFalse(result);
	}
	
	@Test
	void testValidBookingRefForNegatives() {
		boolean result = validate.isValidBookingRef(-5);
		assertFalse(result);
	}
	
	@Test
	void testValidBookingRefForPositives() {
		boolean result = validate.isValidBookingRef(2);
		assertTrue(result);
	}

	@Test
	void testValidScreenNameForEmpty() {
		boolean result = validate.isValidScreenName("");
		assertFalse(result);
	}
	
	@Test
	void testValidScreenNameForNull() {
		boolean result = validate.isValidScreenName(null);
		assertFalse(result);
	}
	
	@Test
	void testValidScreenNameForString() {
		boolean result = validate.isValidScreenName("First");
		assertTrue(result);
	}

}
