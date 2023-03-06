package TimeTwo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTestTwo {
	
	@Test
	void testGetMilliSeconds()
	{
		int milliSeconds = TimeTwo.getMilliSeconds("12:05:05:005");
		assertTrue("The milliseconds where not calculated properly", milliSeconds == 5);
	}
	
	@Test
	void testGetTotalMilliSeconds()
	{
		int milliSeconds = TimeTwo.getTotalMilliSeconds("05:05:05:005");
		assertTrue("The total milliseconds were not calculated properly", milliSeconds == 18305005);
	}
	
	//------------------------------------
	@Test
	void testGetTotalSeconds() {
		int seconds = TimeTwo.getTotalSeconds("00:02:00");
		assertTrue("The seconds were not calculated properly", seconds == 120);
	}
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = TimeTwo.getTotalSeconds("00:01:59");
		assertTrue("The seconds were not calculated properly", seconds == 119);
	}
	@Test
	public void testGetTotalSecondsBad()
	{
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{TimeTwo.getTotalSeconds("10");});
	}
	// -----------------------------------------------------------------------
	@Test
	void testGetSeconds() {
		int seconds = TimeTwo.getTotalSeconds("00:00:05");
		assertTrue("The seconds were not calculated properly", seconds == 5);
	}
	@Test
	void testGetSecondsBoundary() {
		int seconds = TimeTwo.getTotalSeconds("00:00:59");
		assertTrue("The seconds were not calculated properly", seconds == 59);
	}

	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{TimeTwo.getSeconds("10");});
	}
	
	// ------------------------------------------------------------------------
	@ParameterizedTest
	@ValueSource(strings = {"00:12:00", "00:12:15", "00:12:59"})
	void testGetTotalMinutes(String candidate) {
		int minutes = TimeTwo.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes == 12);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{TimeTwo.getTotalMinutes("a20j");});
	}
	// -------------------------------------------------------------------------
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00", "05:15:15", "05:59:59"})
	void testGetTotalHours(String candidate) {
		int hours = TimeTwo.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours == 5);
	}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				NumberFormatException.class,
				()->{TimeTwo.getTotalSeconds("100:100:504");});
	}
}
