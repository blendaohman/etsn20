package lab1;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class branchCoverageSuite extends TestCase{
	private final String INVALID_INPUT_DATE = "Invalid Input Date";
	private final String INVALID_NEXT_YEAR = "Invalid Next Year";
	
	private NextDate date = new NextDate(0, 0, 0); //denna konstruktor e fucked
												//Dessa parametrar verkar kunna vara vad som helst,
												// har inget att göra med resten. Kastas i klassen.


	/* smarta gerejer */
	//assertTrue();
	//assertNull(Object testobject);
	//assertFalse();
	//excepts optional first parameter as string
	//assertEquals("Date was not the same", date1, date2)
	
	/* Date out of range */
	@Test
	public void dateOutOfRange() {

		String nextDate = date.run(10, 2, 1800);
		
		//First string is in case the test does not pass
		assertEquals("Date was invalid but returned valid", INVALID_INPUT_DATE, nextDate);
			
	}
	
	/* Testing correct 31 day month */
	@Test
	public void _31dayMonth() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(1, 30, 1801);
		assertEquals("Date was not matching", "1/31/1801", nextDate);
		
	}
	
	/* Testing correct 31 day month going to next month */
	@Test
	public void _31dayMonthDay31() {
		
		String nextDate = date.run(1, 31, 1801);
		assertEquals("Date was not matching", "2/1/1801", nextDate);
		
	}
	
	/* Testing correct 30 day month */
	@Test
	public void _30dayMonth() {
		
		String nextDate = date.run(4, 1, 1801);
		assertEquals("Date was not matching", "4/2/1801", nextDate);
		
	}
	
	/* Testing correct 30 day month on day 30, going to next month*/
	@Test
	public void _30dayMonthDay30() {
		
		String nextDate = date.run(4, 30, 1801);
		assertEquals("Date was not matching", "5/1/1801", nextDate);
		
	}
	
	/* Testing 30 day month on day 31*/
	@Test
	public void _30dayMonthDay31() {
		
		String nextDate = date.run(4, 31, 1801);
		assertEquals("Date was not matching", INVALID_INPUT_DATE, nextDate);
		
	}
	
	/* Testing december*/
	@Test
	public void december() {
		
		String nextDate = date.run(12, 1, 1801);
		assertEquals("Date was not matching", "12/2/1801", nextDate);
		
	}
	
	/* Testing december*/
	/* Tror detta test inte går igenom för det är fel i koden. Står <= 31 ist för <31 */
	@Test
	public void december31() {
		
		String nextDate = date.run(12, 31, 1801);
		assertEquals("Date was not matching", "1/1/1802", nextDate);
		
	}
	
	@Test
	public void december31Year2021() {
		
		String nextDate = date.run(12, 31, 2021);
		assertEquals("Date was not matching", INVALID_NEXT_YEAR, nextDate);
		
	}

	/* Testing febuary*/
	@Test
	public void febuary() {
		
		String nextDate = date.run(2, 27, 1801);
		assertEquals("Date was not matching", "2/28/1801", nextDate);
		
	}
	
	/* Testing febuary, not a leap year*/
	@Test
	public void febuary28() {
		
		String nextDate = date.run(2, 28, 1801);
		assertEquals("Date was not matching", "3/1/1801", nextDate);
		
	}
	
	/* Testing febuary 28, leap year*/
	@Test
	public void febuary28LeapYear() {
		
		String nextDate = date.run(2, 28, 2020);
		assertEquals("Date was not matching", "2/29/2020", nextDate);
		
	}
	
	/* Testing febuary 28, not a leap year*/
	@Test
	public void febuary28NotLeapYear() {
		
		String nextDate = date.run(2, 28, 2019);
		assertEquals("Date was not matching", "3/1/2019", nextDate);
		
	}
	
	@Test
	public void febuary29LeapYear() {
		
		String nextDate = date.run(2, 29, 2020);
		assertEquals("Date was not matching", "3/1/2020", nextDate);
		
	}
	
	@Test
	public void febuary29NotLeapYear() {
		
		String nextDate = date.run(2, 29, 2019);
		assertEquals("Date was not matching", INVALID_INPUT_DATE, nextDate);
		
	}

	@Test
	public void febuary30() {
		
		String nextDate = date.run(2, 30, 2020);
		assertEquals("Date was not matching", INVALID_INPUT_DATE, nextDate);
		
	}
	
	
	

}
