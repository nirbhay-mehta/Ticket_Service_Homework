package stadium;

import java.util.*;

public class Rows {
	private int rowid;
	// arraylist i used since user can book multiple seats
	private ArrayList<SeatHold> seat;

	// getters and setters for rowid
	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	// getters and setters for seat hold/reserved
	public ArrayList<SeatHold> getSeat() {
		return seat;
	}

	public void setSeat(ArrayList<SeatHold> seat) {
		this.seat = seat;
	}
}
