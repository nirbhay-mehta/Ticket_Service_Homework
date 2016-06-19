package stadium;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class find_total_seats {

	@Test
	public void test() {
		Venue v = new Venue();
		Entry_point ep = new Entry_point();
		ArrayList<Level> al = v.getVenueLevel();
		int expected_output = ep.numSeatsAvailable(1);
		System.out.println(expected_output);
		assertEquals(1250,expected_output);
	}

}
