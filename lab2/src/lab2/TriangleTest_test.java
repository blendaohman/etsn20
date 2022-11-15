package lab2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import junit.framework.*;
import junit.framework.TestCase;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTest_test {

	private Triangle rightAngledTriangle;
	private Triangle equilateralTriangle;
	private Triangle isoscelesTriangle;
	private Triangle scaleneTriangle;
	private Triangle impossibleTriangle;
	
	private Triangle rightAngledTriangleInvalid;
	private Triangle equilateralTriangleInvalid;
	private Triangle isoscelesTriangleInvalid;
	private Triangle scaleneTriangleInvalid;
	private Triangle impossibleTriangleInvalid;

	
	
	@BeforeClass
	/*
	 * The method run once before any of the test methods in the class.
	 */
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	/* 
	 * The method will be run after all the tests in the class have been run
	 */
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	/*
	 * Initializes common objects. The method will be run before the Test method.
	 */
	public void setUp() throws Exception {
		rightAngledTriangle = new Triangle(3, 4, 5);
		equilateralTriangle = new Triangle(1, 1, 1);
		isoscelesTriangle = new Triangle(2, 2, 1);
		scaleneTriangle = new Triangle(2, 3, 4);
		impossibleTriangle = new Triangle(1, 1, 10);
		
		rightAngledTriangleInvalid = new Triangle(-3, -4, -5);
		equilateralTriangleInvalid = new Triangle(-1, -1, -1);
		isoscelesTriangleInvalid = new Triangle(0, 0, 1);
		scaleneTriangleInvalid = new Triangle(-2, 3, 4);
		impossibleTriangleInvalid = new Triangle(1, 1, -10);
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
		rightAngledTriangle = null;
		equilateralTriangle = null;
		isoscelesTriangle = null;
		scaleneTriangle = null;
		impossibleTriangle = null;
		
		rightAngledTriangleInvalid = null;
		equilateralTriangleInvalid = null;
		isoscelesTriangleInvalid = null;
		scaleneTriangleInvalid = null;
		impossibleTriangleInvalid = null;
	}

	@Test
	/* 
	 * Tests whether the triangle specified in the fixture (setUp) 
	 * is right-angled. 	
	 *
	 * A public void method that is attached to be run as a test case. 
	 * To run the method, JUnit first constructs a fresh instance of the class then 
	 * invokes the annotated method. Any exceptions thrown by the test will be reported
	 * by JUnit as a failure. If no exceptions are thrown, the test is assumed to have 
	 * succeeded. 
	*/
	public void rightAngleValid() {
		assertTrue("Should return true for a right-angled triangle", rightAngledTriangle.isRightAngled());
		assertEquals(6, rightAngledTriangle.getArea());
		assertEquals(12, rightAngledTriangle.getPerimeter());
		assertEquals("3,4,5", rightAngledTriangle.getSideLengths());
		assertEquals("right-angled", rightAngledTriangle.classify());		
	}
	
	//Not really done
	@Test
	public void rightAngleInvalid() {
		assertFalse("Should return true for a right-angled triangle", rightAngledTriangleInvalid.isRightAngled());
		assertEquals(-1, rightAngledTriangleInvalid.getArea()); 
		assertEquals("-3,-4,-5", rightAngledTriangleInvalid.getSideLengths());
		assertEquals("impossible", rightAngledTriangleInvalid.classify());	//Impossible works for negative number but not when a side is to long	
	}
	
	//need proof reading
	@Test
	public void equilateralTriangleValid() {
		assertTrue("Should return false for a invalid equilateral Triangle", equilateralTriangle.isEquilateral());
		//assertEquals(0.433, equilateralTriangle.getArea()); //Dose not woork get 0.0 which is wrong, SVÄR de har int och inte double!!!
		assertEquals(-12, rightAngledTriangleInvalid.getPerimeter());
		assertEquals(3, equilateralTriangle.getPerimeter());
		assertEquals("1,1,1", equilateralTriangle.getSideLengths());
		assertEquals("equilateral", equilateralTriangle.classify());		
	}

	@Test
	public void equilateralTriangleInvalid() {
		//assertFalse("Should return false for a invalid equilateral Triangle", equilateralTriangleInvalid.isEquilateral()); //Wrong! Is True even if it is impossible
		assertEquals(-1, equilateralTriangleInvalid.getArea());
		assertEquals(-3, equilateralTriangleInvalid.getPerimeter());
		assertEquals("-1,-1,-1", equilateralTriangleInvalid.getSideLengths());
		assertEquals("impossible", equilateralTriangleInvalid.classify());		
	}
	
	@Test
	public void isoscelesTriangleValid() {
		assertTrue("Should return true for a isoscelesTriangle triangle", isoscelesTriangle.isIsosceles());
		//assertEquals(0.968, isoscelesTriangle.getArea()); //Dose not woork get 0.0 which is wrong
		assertEquals(5, isoscelesTriangle.getPerimeter());
		assertEquals("2,2,1", isoscelesTriangle.getSideLengths());
		assertEquals("isossceles", isoscelesTriangle.classify());		
	}

	// TO-DO IsosscelsInvalid
	
	@Test
	public void scaleneTriangleValid() {
		assertTrue("Should return true for a scalene triangle", scaleneTriangle.isScalene());
		//assertEquals(2.905, scaleneTriangle.getArea()); //Dose not woork get 0.0 which is wrong
		assertEquals(9, scaleneTriangle.getPerimeter());
		assertEquals("2,3,4", scaleneTriangle.getSideLengths());
		assertEquals("scalene", scaleneTriangle.classify());		
	}

	// TO-DO scaleneInvalid

	@Test
	public void ImpossibleValid() {
		//assertTrue("Should return true for an impossible triangle", impossibleTriangle.isImpossible());
		//assertEquals(-1, impossibleTriangle.getArea()); //Får NaN för den fattar inte den är impossible
		assertEquals(12, impossibleTriangle.getPerimeter());
		assertEquals("1,1,10", impossibleTriangle.getSideLengths());
		//assertEquals("Impossible", impossibleTriangle.classify());	//Get isosceles pga 2 same leg but should be impossiebe	
	}

	// TO-DO ImpossibleInvalid
}