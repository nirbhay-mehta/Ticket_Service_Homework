package stadium;

import java.util.ArrayList;

public class Venue {
	private int venue_id;
	private static ArrayList<Level> venueLevel;

	/// getters and setters for venue_id
	public int getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}

	/// getters and setters for venuelevel
	public static ArrayList<Level> getVenueLevel() {
		return venueLevel;
	}

	public static void setVenueLevel(ArrayList<Level> venueLevel) {
		Venue.venueLevel = venueLevel;
	}

}
