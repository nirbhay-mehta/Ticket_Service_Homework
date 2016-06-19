package stadium;

import java.text.SimpleDateFormat;
import java.util.*;

public class Entry_point {
	Venue v = new Venue();

	public static void main(String[] args) {
		Entry_point ep = new Entry_point();
		ep.initializeTicketingSystem();

		// Accept the use case which user wants to execute
		int useCaseNo = 4;
		do {
			System.out.println("Select from the below use case:");
			System.out.println("Press 1 --> To find the no of available seats");
			System.out.println("Press 2 --> To hold the best available seat for yourself!");
			System.out.println("Press 3 --> To reserve the seats - Only if you have hold the seats");
			Scanner sc = new Scanner(System.in);
			useCaseNo = sc.nextInt();
			ep.executeUseCase(useCaseNo);
			if (useCaseNo == 5) {
				break;
			}
		} while (useCaseNo != 5);

	}

	public void initializeTicketingSystem() {
		// Setting the details for Level1
		Level level1 = new Level();
		level1.setLevel_id(1);
		level1.setLevel_name("Orchcestra");
		level1.setLevel_price(100);
		// Initialize Rows for Level
		ArrayList<Rows> rowsInLevel = new ArrayList<Rows>();
		for (int rowNo = 1; rowNo <= 25; rowNo++) {
			Rows row = new Rows();
			// Initialize Seats per row
			initializeSeatsPerRow(row, 50);
			rowsInLevel.add(row);
		}
		level1.setRows(rowsInLevel);

		// Setting the details for Level2
		Level level2 = new Level();
		level2.setLevel_id(2);
		level2.setLevel_name("Main");
		level2.setLevel_price(75);
		// Initialize Rows for Level
		ArrayList<Rows> rowsInSecondLevel = new ArrayList<Rows>();
		for (int rowNo = 1; rowNo <= 20; rowNo++) {
			Rows row = new Rows();
			// Initialize Seats per row
			initializeSeatsPerRow(row, 100);
			rowsInSecondLevel.add(row);
		}
		level2.setRows(rowsInSecondLevel);

		// Setting the details for Level3
		Level level3 = new Level();
		level3.setLevel_id(3);
		level3.setLevel_name("Balcony 1");
		level3.setLevel_price(50);
		// Initialize Rows for Level
		ArrayList<Rows> rowsInThirdLevel = new ArrayList<Rows>();
		for (int rowNo = 1; rowNo <= 15; rowNo++) {
			Rows row = new Rows();
			// Initialize Seats per row
			initializeSeatsPerRow(row, 100);
			rowsInThirdLevel.add(row);
		}
		level3.setRows(rowsInThirdLevel);

		// Setting the details for Level4
		Level level4 = new Level();
		level4.setLevel_id(4);
		level4.setLevel_name("Balcony 2");
		level4.setLevel_price(40);
		// Initialize Rows for Level
		ArrayList<Rows> rowsInForthLevel = new ArrayList<Rows>();
		for (int rowNo = 1; rowNo <= 15; rowNo++) {
			Rows row = new Rows();
			// Initialize Seats per row
			initializeSeatsPerRow(row, 100);
			rowsInForthLevel.add(row);
		}
		level4.setRows(rowsInForthLevel);

		//	Venue v = new Venue();
		ArrayList<Level> al = new ArrayList<Level>();
		al.add(level1);
		al.add(level2);
		al.add(level3);
		al.add(level4);
		v.setVenueLevel(al);
	}

	// Initializing seats for each row
	public void initializeSeatsPerRow(Rows row, int numSeats) {
		ArrayList<SeatHold> seatsInRow = new ArrayList<SeatHold>();
		for (int seatNo = 1; seatNo <= numSeats; seatNo++) {
			SeatHold seat = new SeatHold();
			seat.setSeatid();
			seat.seatStatus = SeatStatusType.AVAILABLE;
			seatsInRow.add(seat);

		}
		row.setSeat(seatsInRow);
	}

	// Switch case to decide which usecase to execute
	public void executeUseCase(int useCaseNo) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		switch (useCaseNo) {
		case 1:
			findAvailableSeats();
			break;
		case 2:
			al = holdbestavailableSeats();
		case 3:
			Scanner email = new Scanner(System.in);
			System.out.println("Press 1 to RESERVE or any other number to EXIT");
			int hold_to_reserve = email.nextInt();
			if (hold_to_reserve == 1) {
				System.out.println("Enter email");
				String customer_email = email.next();

				reserveSeats(al, customer_email);
			}

			break;

		}
	}

	// for user input
	public void findAvailableSeats() {
		System.out.println("Select the level number where you want to check the availability");
		System.out.println("Press 1 --> Orchestra  -->100$ --> " + " Minimum Level");
		System.out.println("Press 2 --> Main --> 75$");
		System.out.println("Press 3 --> Balcony1 --> 50$");
		System.out.println("Press 4 --> Balacony2 --> 40$ -->  " + "Maximum Level");
		System.out.println("Press 5 --> To find the total seats available in the stadium");
		Scanner lsc = new Scanner(System.in);
		int venueLevel = lsc.nextInt();

		numSeatsAvailable(venueLevel);
	}

	// to find the seats available per level
	public int numSeatsAvailable(int venueLevel) {
		HashMap<Integer, Integer> seatsavailable = new HashMap<Integer, Integer>();

		ArrayList<Level> al = v.getVenueLevel();
		// total variable is used to find the toal # of seats available
		int total = 0;
		for (Level level : al) {
			int count = 0;
			convert_hold_toAvailable(level.getLevel_id());
			ArrayList<Rows> ar = level.getrow();

			for (Rows row : ar) {
				ArrayList<SeatHold> s = row.getSeat();
				for (SeatHold seat : s) {
					if (seat.seatStatus == SeatStatusType.AVAILABLE) {
						total++;
						count++;

					}
				}
			}
			seatsavailable.put(level.getLevel_id(), count);
		}
		int n = 0;
		switch (venueLevel) {
		case 1:
			n = seatsavailable.get(1);
			System.out.println("Currently seats available : " + n);
			break;
		case 2:
			n = seatsavailable.get(2);
			System.out.println("Currently seats available : " + n);
			break;
		case 3:
			n = seatsavailable.get(3);
			System.out.println("Currently seats available : " + n);
			break;
		case 4:
			n = seatsavailable.get(4);
			System.out.println("Currently seats available : " + n);
			break;
		default:
			System.out.println("Sorry its an invalid entry!");

			break;
		case 5:
			n = total;
			System.out.println("Total seats available : " + n);
			break;
		}

		return n;
	}

	/*
	 * public void selectVenuelevel(int levelId, int rows, int seats, String
	 * name) { Hashtable<Integer, String> source = new Hashtable<Integer,
	 * String>(); HashMap<Integer, String> map = new HashMap(source); for (int i
	 * = 0; i < rows; i++) { for (int s = 0; s < seats; s++) map.put(seats,
	 * name); } System.out.println("Seat No is" + seats + "Name" + name); }
	 */
	// getting the user details
	public ArrayList<Integer> holdbestavailableSeats() {
		Scanner hold = new Scanner(System.in);
		System.out.println("Enter the level which you want to book for");
		System.out.println("Press 1 --> Orchestra  --> " + " Minimum Level");
		System.out.println("Press 2 --> Main");
		System.out.println("Press 3 --> Balcony1");
		System.out.println("Press 4 --> Balacony2 -->   " + "Maximum Level");
		int venueLevel = hold.nextInt(); //
		System.out.println("Enter the # of tickets to be booked");
		int hold_ticket = hold.nextInt();
		System.out.println("Enter the email");
		String customer_email = hold.next();
		return findAndHoldSeats(hold_ticket, venueLevel, customer_email);
	}

	// finding the best seats for the users
	public ArrayList<Integer> findAndHoldSeats(int hold_ticket, int venueLevel, String customer_email) {
		Scanner hold = new Scanner(System.in);
		int capacity_of_level = numSeatsAvailable(venueLevel);
		convert_hold_toAvailable(venueLevel);
		ArrayList<Integer> seatsIds = new ArrayList<Integer>();
		if (capacity_of_level >= hold_ticket) {
			ArrayList<Level> al = v.getVenueLevel();
			int count = 0;
			for (Level level : al) {
				if (venueLevel == level.getLevel_id()) {

					ArrayList<Rows> ar = level.getrow();

					for (Rows row : ar) {
						ArrayList<SeatHold> s = row.getSeat();
						for (SeatHold seat : s) {
							if (seat.seatStatus == SeatStatusType.AVAILABLE) {
								if (count >= hold_ticket) {
									System.out.println("Tickets hold");
									System.out.println(seatsIds);
									return seatsIds;
								}
								seat.seatStatus = SeatStatusType.ONHOLD;
								Date d = new Date();
								seat.setOnHoldTime(d.getTime());
								seatsIds.add(seat.getSeatid());
								count++;

							}
						}
					}
				}

			}

		}

		/*
		 * SeatHold hold_seatid = new SeatHold(); if (hold_seatid.seatStatus ==
		 * SeatStatusType.AVAILABLE) { hold_seatid.seatStatus =
		 * SeatStatusType.ONHOLD; } else { checkholdtickets(hold_ticket); }
		 * return seatsIds; } // ****************************** void
		 * checkholdtickets(int hold_ticket) { SeatHold hold_seatid = new
		 * SeatHold(); // if trying to hold the reserrved seats if
		 * (hold_seatid.seatStatus == SeatStatusType.RESERVED) {
		 * System.out.println("Sorry it is already being boooked"); } // if the
		 * seats is available making it hold else if (hold_seatid.seatStatus ==
		 * SeatStatusType.ONHOLD) {
		 * 
		 * } // ************************************ Calendar cal =
		 * Calendar.getInstance(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("HH:mm:ss"); String format =
		 * sdf.format(cal.getTime()); System.out.println(format);
		 */
		return seatsIds;
	}

	/// making hold seats to available for user if the seatis not reserved is
	/// greater within 60seconds
	public void convert_hold_toAvailable(int vl) {
		Calendar cal = Calendar.getInstance();
		Date d = new Date();
		ArrayList<Level> al = v.getVenueLevel();
		int count = 0;
		for (Level level : al) {
			if (vl == level.getLevel_id()) {
				ArrayList<Rows> ar = level.getrow();
				for (Rows row : ar) {
					ArrayList<SeatHold> s = row.getSeat();
					for (SeatHold seat : s) {
						if ((seat.seatStatus == SeatStatusType.ONHOLD)
								&& (Math.abs(d.getTime() - seat.getOnHoldTime())) > 120000) {
							seat.seatStatus = SeatStatusType.AVAILABLE;

						}
					}
				}
			}

		}
	}

	// if the user has hold the seat then only the user can reserve the seats
	// since when user holds the seat seatid is given
	public String reserveSeats(ArrayList<Integer> seatHoldId, String customeremail) {
		ArrayList<Level> al = v.getVenueLevel();

		for (Level level : al) {

			ArrayList<Rows> ar = level.getrow();

			for (Rows row : ar) {
				ArrayList<SeatHold> s = row.getSeat();
				for (SeatHold seat : s) {
					for (int i : seatHoldId) {
						if (i == seat.getSeatid()) {
							seat.seatStatus = SeatStatusType.RESERVED;
							System.out.println(seat.getSeatid() + " " + seat.seatStatus);
						}
					}
				}
			}
		}
		String ids = "Ticket ids are --> ";
		for (Integer i : seatHoldId) {
			ids = ids + " " + i;
		}
		return ids;

	}

}