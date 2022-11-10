package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatmentCoverageSuite {
	
	private NextDate date = new NextDate(0, 0, 0);
	
	private final String INVALID_NEXT_YEAR = "Invalid Next Year";
	private final String INVALID_INPUT_DATE = "Invalid Input Date";

	
	/* Testing correct 30 day month */
	@Test
	public void _30dayMonth() {
		
		String nextDate = date.run(4, 1, 1801);
		assertEquals( "4/2/1801", nextDate);
		
	}
	
	/* Testing correct 30 day month on day 30, going to next month*/
	@Test
	public void _30dayMonthDay30() {
		
		String nextDate = date.run(4, 30, 1801);
		assertEquals("5/1/1801", nextDate);
		
	}
	
	/* Testing correct 31 day month */
	@Test
	public void _31dayMonth() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(1, 30, 1801);
		assertEquals("1/31/1801", nextDate);
		
	}
	
	/* Testing december*/
	@Test
	public void december() {
		
		String nextDate = date.run(12, 1, 1801);
		assertEquals("12/2/1801", nextDate);
		
	}
	
	@Test
	public void december31Year2021() {
		
		String nextDate = date.run(12, 31, 2021);
		assertEquals(INVALID_NEXT_YEAR, nextDate);
		
	}
	
	/* Testing febuary*/
	@Test
	public void febuary() {
		
		String nextDate = date.run(2, 27, 1801);
		assertEquals("2/28/1801", nextDate);
		
	}
	/* Testing febuary, not a leap year*/
	@Test
	public void febuary28() {
		
		String nextDate = date.run(2, 28, 1801);
		assertEquals("3/1/1801", nextDate);
		
	}
	
	/* Testing febuary 28, leap year*/
	@Test
	public void febuary28LeapYear() {
		
		String nextDate = date.run(2, 28, 2020);
		assertEquals("2/29/2020", nextDate);
		
	}
	
	@Test
	public void febuary29LeapYear() {
		
		String nextDate = date.run(2, 29, 2020);
		assertEquals("3/1/2020", nextDate);
		
	}
	
	@Test
	public void febuary30() {
		
		String nextDate = date.run(2, 30, 2020);
		assertEquals( INVALID_INPUT_DATE, nextDate);
		
	}
	
	/* Date out of range */
	@Test
	public void dateOutOfRange() {

		String nextDate = date.run(10, 2, 1800);
		
		//First string is in case the test does not pass
		assertEquals(INVALID_INPUT_DATE, nextDate);
			
	}
	
	
	
}
