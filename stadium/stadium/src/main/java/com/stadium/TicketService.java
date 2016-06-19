package stadium;

import java.util.ArrayList;
import java.util.Optional;

public interface TicketService {
// can find total seats in stadium or by level
	int numSeatsAvailable(int v1);
// here arraylist is used since user can hold multiple seats
	ArrayList<Integer> findAndHoldSeats(int naumSeats, int Level, String customerEmail);
// user can reserve seats
	String reserveSeats(ArrayList<Integer> seatHoldId, String customeremail);
}
