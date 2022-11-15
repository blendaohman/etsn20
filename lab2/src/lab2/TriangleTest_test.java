package lab2;

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
		assertTrue("Should return true for a right-angled triangle", rightAngledTriangle.isRightAngled());
		assertEquals(6, rightAngledTriangle.getArea());
		assertEquals(12, rightAngledTriangle.getPerimeter());
		assertEquals("3,4,5", rightAngledTriangle.getSideLengths());
		assertEquals("right-angled", rightAngledTriangle.classify());		
	}
	
	//need proof reading
	@Test
	public void equilateralTriangleValid() {
		assertTrue("Should return true for a equilateral Triangle", equilateralTriangle.isEquilateral());
		assertEquals(0,.5, equilateralTriangle.getArea());
		assertEquals(3, equilateralTriangle.getPerimeter());
		assertEquals("1,1,1", equilateralTriangle.getSideLengths());
		assertEquals("Equilateral", equilateralTriangle.classify());		
	}
	
	@Test
	public void isoscelesTriangleValid() {
		assertTrue("Should return true for a isoscelesTriangle triangle", isoscelesTriangle.isIsosceles()());
		assertEquals(, isoscelesTriangle.getArea());
		assertEquals(, isoscelesTriangle.getPerimeter());
		assertEquals("", isoscelesTriangle.getSideLengths());
		assertEquals("", isoscelesTriangle.classify());		
	}
	
	@Test
	public void scaleneTriangleValid() {
		assertTrue("Should return true for a scalene triangle", scaleneTriangle.isScalene());
		assertEquals(, scaleneTriangle.getArea());
		assertEquals(, scaleneTriangle.getPerimeter());
		assertEquals("", scaleneTriangle.getSideLengths());
		assertEquals("", scaleneTriangle.classify());		
	}
	
	@Test
	public void ImpossibleValid() {
		assertTrue("Should return true for an impossible triangle", impossibleTriangle.isImpossible());
		assertEquals(, impossibleTriangle.getArea());
		assertEquals(, impossibleTriangle.getPerimeter());
		assertEquals("", impossibleTriangle.getSideLengths());
		assertEquals("", impossibleTriangle.classify());		
	}
}
