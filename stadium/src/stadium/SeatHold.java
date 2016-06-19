package stadium;

import java.util.Calendar;
import java.util.Date;

public class SeatHold {
	private int seatid;
	public SeatStatusType seatStatus;
	private long onHoldTime;
	private static int no = 0;

	// getters and setters is declared for seatid
	public int getSeatid() {
		return seatid;
	}

	public void setSeatid() {
		this.seatid = no + 1;
		no++;
	}

	// getters and setters for onholdtime
	public long getOnHoldTime() {
		return onHoldTime;
	}

	public void setOnHoldTime(long onHoldTime) {
		this.onHoldTime = onHoldTime;
	}

}
