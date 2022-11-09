package lab1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;


class predicateCoverageSuite {
	private final String INVALID_INPUT_DATE = "Invalid Input Date";
	private final String INVALID_NEXT_YEAR = "Invalid Next Year";

	private NextDate date = new NextDate(0, 0, 0); 
	
	@Test
	public void _31dayMonths() {
		//Datum returneras MM/DD/YY
		String nextDate = date.run(1, 1, 2020);
		boolean jan = nextDate.equals("1/2/2020");
		
		nextDate = date.run(3, 1, 2020);
		boolean mar = nextDate.equals("3/2/2020");
		
		nextDate = date.run(5, 1, 2020);
		boolean may = nextDate.equals("5/2/2020");
		
		nextDate = date.run(7, 1, 2020);
		boolean jul = nextDate.equals("7/2/2020");
		
		nextDate = date.run(8, 1, 2020);
		boolean aug = nextDate.equals("8/2/2020");
		
		
		nextDate = date.run(10, 1, 2020);
		boolean oct = nextDate.equals("10/2/2020");
		
		nextDate = date.run(12, 1, 2020);
		boolean dec = nextDate.equals("12/2/2020");

		assertTrue("31 month did not all work", jan && mar && may && jul && aug && oct && dec);
	}
	
	/* Testing correct 31 day month going to next month */
	@Test
	public void _31dayMonthDay31() {
		
		String nextDate = date.run(1, 31, 1801);
		assertEquals("Date was not matching", "2/1/1801", nextDate);
		
	}
	
	
	
	/* Testing correct 30 day month */
	@Test
	public void _30dayMonths() {
		
		String nextDate = date.run(4, 1, 2020);
		boolean apr = nextDate.equals("9/2/2020");
		
		nextDate = date.run(6, 1, 2020);
		boolean jun = nextDate.equals("6/2/2020");
		
		nextDate = date.run(9, 1, 2020);
		boolean sep = nextDate.equals("9/2/2020");
		
		nextDate = date.run(11, 1, 2020);
		boolean nov = nextDate.equals("11/2/2020");
		
		assertTrue("30 month did not all work", apr && jun && sep && nov);
		
	}
	

	/* Testing correct 30 day month on day 30, going to next month*/
	@Test
	public void _30dayMonthDay30() {
		
		String nextDate = date.run(4, 30, 1801);
		assertEquals("Date was not matching", "5/1/1801", nextDate);
	}
	
	
	/* Test all possible dates out of range */
	@Test
	public void allDateOutOfRange() {

		String nextDate = date.run(10, 2, 1800);
		
		//First string is in case the test does not pass
		assertEquals("Date was invalid but returned valid", INVALID_INPUT_DATE, nextDate);
			
	}

}
