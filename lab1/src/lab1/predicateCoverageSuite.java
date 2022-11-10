package lab1;


import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;


class predicateCoverageSuite {
	private final String INVALID_INPUT_DATE = "Invalid Input Date";
	private final String INVALID_NEXT_YEAR = "Invalid Next Year";
	private final String NOT_MATCHING = "Date was not matching";

	private NextDate date = new NextDate(0, 0, 0); 
	
	@Test
	public void january() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(1, 1, 2020);
		assertEquals(nextDate, "1/2/2020");
	}
	
	@Test
	public void march() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(3, 1, 2020);
		assertEquals(nextDate, "3/2/2020");
	}
	
	@Test
	public void may() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(5, 1, 2020);
		assertEquals(nextDate, "5/2/2020");
	}
	
	@Test
	public void july() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(7, 1, 2020);
		assertEquals(nextDate, "7/2/2020");
	}
	
	@Test
	public void august() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(8, 1, 2020);
		assertEquals(nextDate, "8/2/2020");
	}
	
	@Test
	public void october() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(10, 1, 2020);
		assertEquals(nextDate, "10/2/2020");
	}
	
	
	/* Testing correct 31 day month going to next month */
	@Test
	public void _31dayMonthDay31() {
		
		String nextDate = date.run(1, 31, 1801);
		assertEquals("2/1/1801", nextDate);
		
	}
	
	/* Testing correct 30 day month */
	@Test
	public void april() {
		String nextDate = date.run(4, 1, 2020);
		assertEquals(nextDate, "4/2/2020");
		
	}
	
	@Test
	public void june() {
		String nextDate = date.run(6, 1, 2020);
		assertEquals(nextDate, "6/2/2020");
		
	}
	
	@Test
	public void september() {
		String nextDate = date.run(9, 1, 2020);
		assertEquals(nextDate, "9/2/2020");
		
	}
	
	@Test
	public void november() {
		String nextDate = date.run(11, 1, 2020);
		assertEquals(nextDate, "11/2/2020");
		
	}
	
	

	/* Testing correct 30 day month on day 30, going to next month*/
	@Test
	public void _30dayMonthDay30() {
		
		String nextDate = date.run(4, 30, 1801);
		assertEquals(nextDate, "5/1/1801");
	}
	
	
	/* Test all possible dates out of range */
	@Test
	public void dayOutOfRange() {

		String nextDate = date.run(1, 0, 1801);
		
		//First string is in case the test does not pass
		assertEquals(INVALID_INPUT_DATE, nextDate, "Date was invalid but returned valid");
			
	}

	/* Date out of range */
	@Test
	public void monthTooBig() {

		String nextDate = date.run(13, 1, 1801);
		
		//First string is in case the test does not pass
		assertEquals( INVALID_INPUT_DATE, nextDate, "Date was invalid but returned valid");
			
	}
	
	/* Date out of range */
	@Test
	public void monthTooSmall() {

		String nextDate = date.run(0, 1, 1801);
		
		//First string is in case the test does not pass
		assertEquals( INVALID_INPUT_DATE, nextDate, "Date was invalid but returned valid");
			
	}
	
	/* Date out of range */
	@Test
	public void yearTooBig() {

		String nextDate = date.run(1, 1, 2022);
		
		//First string is in case the test does not pass
		assertEquals( INVALID_INPUT_DATE, nextDate, "Date was invalid but returned valid");
			
	}
	
	/* Date out of range */
	@Test
	public void yearTooSmall() {

		String nextDate = date.run(1, 1, 1800);
		
		//First string is in case the test does not pass
		assertEquals( INVALID_INPUT_DATE, nextDate, "Date was invalid but returned valid");
			
	}
	
	/* Testing correct 31 day month */
	@Test
	public void _31dayMonth() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(1, 30, 1801);
		assertEquals("1/31/1801", nextDate);
		
	}
	
	
	/* Testing correct 30 day month */
	@Test
	public void _30dayMonth() {
		
		String nextDate = date.run(4, 1, 1801);
		assertEquals("4/2/1801", nextDate);
		
	}
	
	
	/* Testing 30 day month on day 31*/
	@Test
	public void _30dayMonthDay31() {
		
		String nextDate = date.run(4, 31, 1801);
		assertEquals(INVALID_INPUT_DATE, nextDate);
		
	}
	
	/* Testing december*/
	@Test
	public void december() {
		
		String nextDate = date.run(12, 1, 1801);
		assertEquals("12/2/1801", nextDate);
		
	}
	
	/* Testing december*/
	/* Tror detta test inte går igenom för det är fel i koden. Står <= 31 ist för <31 */
	@Test
	public void december31() {
		
		String nextDate = date.run(12, 31, 1801);
		assertEquals("1/1/1802", nextDate);
		
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
	
	/* Testing febuary 28, not a leap year*/
	@Test
	public void febuary28NotLeapYear() {
		
		String nextDate = date.run(2, 28, 2019);
		assertEquals("3/1/2019", nextDate);
		
	}
	
	@Test
	public void febuary29LeapYear() {
		
		String nextDate = date.run(2, 29, 2020);
		assertEquals("3/1/2020", nextDate);
		
	}
	
	@Test
	public void febuary29NotLeapYear() {
		
		String nextDate = date.run(2, 29, 2019);
		assertEquals(INVALID_INPUT_DATE, nextDate);
		
	}

	@Test
	public void febuary30() {
		
		String nextDate = date.run(2, 30, 2020);
		assertEquals(INVALID_INPUT_DATE, nextDate);
		
	}
	
	@Test
	public void evenLeapYear() {
		
		String nextDate = date.run(2, 29, 2000);
		assertEquals("3/1/2000", nextDate);
		
	}
	
	@Test
	public void unEvenLeapYear() {
		
		String nextDate = date.run(2, 29, 1900);
		assertEquals("3/1/2000", nextDate);
		
	}
	
	
	
}
