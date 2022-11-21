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
public class TriangleTest_EP {

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
		isoscelesTriangleInvalid = new Triangle(-2,-2, 1);
		scaleneTriangleInvalid = new Triangle(-2,-3,-4);
		impossibleTriangleInvalid = new Triangle(1, 1, -10);
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
//		rightAngledTriangle = null;
//		equilateralTriangle = null;
//		isoscelesTriangle = null;
//		scaleneTriangle = null;
//		impossibleTriangle = null;
//		
//		rightAngledTriangleInvalid = null;
//		equilateralTriangleInvalid = null;
//		isoscelesTriangleInvalid = null;
//		scaleneTriangleInvalid = null;
//		impossibleTriangleInvalid = null;
	}

	
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

	@Test
	public void rightAngleValidIsTrue() {
		assertTrue("Should return true for a right-angled triangle", rightAngledTriangle.isRightAngled());
	}

	@Test
	public void rightAngleValidArea() {
		assertEquals(6, rightAngledTriangle.getArea());
	}

	@Test
	public void rightAngleValidParimeter() {
		assertEquals(12, rightAngledTriangle.getPerimeter());
	}

	@Test
	public void rightAngleValidSideLenght() {
		assertEquals("3,4,5", rightAngledTriangle.getSideLengths());
	}

	@Test
	public void rightAngleValidclassify() {
		assertEquals("right-angled", rightAngledTriangle.classify());	
	}

	@Test
	public void rightAngleInvalidIsFalse() {
		assertFalse("Should return false for a invalid right-angled triangle", rightAngledTriangleInvalid.isRightAngled());
	}

	@Test
	public void rightAngleInvalidIsArea() {
		assertEquals(-1, rightAngledTriangleInvalid.getArea()); 
	}

	@Test
	public void rightAngleInvalidIsPerimiter() {
		assertEquals(-12, rightAngledTriangleInvalid.getPerimeter());
	}

	@Test
	public void rightAngleInvalidIsSideLenght() {
		assertEquals("-3,-4,-5", rightAngledTriangleInvalid.getSideLengths());
	}

	@Test
	public void rightAngleInvalidIsClassify() {
		assertEquals("impossible", rightAngledTriangleInvalid.classify());	//Impossible works for negative number but not when a side is to long	
	}

	@Test
	public void equilateralTriangleValidIsTrue() {
		assertTrue("Should return false for a invalid equilateral Triangle", equilateralTriangle.isEquilateral());
	}
	@Test
	public void equilateralTriangleValidArea() {
		assertEquals(0.433, equilateralTriangle.getArea()); //Dose not woork get 0.0 which is wrong, SVÄR de har int och inte double!!!
	}

	@Test
	public void equilateralTriangleValidPerimiter() {
		assertEquals(3, equilateralTriangle.getPerimeter());
	}
		
	@Test
	public void equilateralTriangleValidSideLenght() {
		assertEquals("1,1,1", equilateralTriangle.getSideLengths());
	}

	@Test
	public void equilateralTriangleValidClassify() {
		assertEquals("equilateral", equilateralTriangle.classify());
	}
	//need proof reading

	@Test
	public void equilateralTriangleInvalidIsFalse() {
		assertFalse("Should return false for a invalid equilateral Triangle", equilateralTriangleInvalid.isEquilateral()); //Wrong! Is True even if it is impossible
	}

	@Test
	public void equilateralTriangleInvalidArea() {
		assertEquals(-1, equilateralTriangleInvalid.getArea());
	}
	@Test
	public void equilateralTriangleInvalidPerimeter() {
		assertEquals(-3, equilateralTriangleInvalid.getPerimeter());
	}
	@Test
	public void equilateralTriangleInvalidSideLenght() {
		assertEquals("-1,-1,-1", equilateralTriangleInvalid.getSideLengths());
	}
	@Test
	public void equilateralTriangleInvalidClassify() {
		assertEquals("impossible", equilateralTriangleInvalid.classify());
	}
	
	@Test 
	public void isoscelesTriangleValidisTrue(){
		assertTrue("Should return true for a isoscelesTriangle triangle", isoscelesTriangle.isIsosceles());
	}
	
	@Test 
	public void isoscelesTriangleValidArea(){
		assertEquals(0.968, isoscelesTriangle.getArea()); //Dose not woork get 0.0 which is wrong
	}
	
	@Test 
	public void isoscelesTriangleValidPerimeter(){
		assertEquals(5, isoscelesTriangle.getPerimeter());
	}
	
	@Test 
	public void isoscelesTriangleValidSideLength(){
		assertEquals("2,2,1", isoscelesTriangle.getSideLengths());
	}
	
	@Test 
	public void isoscelesTriangleValidClassify(){
		assertEquals("isossceles", isoscelesTriangle.classify());
	}
	
	@Test 
	public void scaleneTriangleValidisTrue(){
		assertTrue("Should return true for a scalene triangle", scaleneTriangle.isScalene());
	}
	
	@Test 
	public void scaleneTriangleValidArea(){
		assertEquals(2.905, scaleneTriangle.getArea()); //Dose not woork get 0.0 which is wrong
	}
	
	@Test 
	public void scaleneTriangleValidPerimeter(){
		assertEquals(9, scaleneTriangle.getPerimeter());
	}
	
	@Test 
	public void scaleneTriangleValidSideLength(){
		assertEquals("2,3,4", scaleneTriangle.getSideLengths());
	}
	
	@Test 
	public void scaleneTriangleValidClassify(){
		assertEquals("scalene", scaleneTriangle.classify());
	}
	
	@Test 
	public void impossibleTriangleValidisTrue(){
		assertTrue("Should return true for an impossible triangle", impossibleTriangle.isImpossible()); // SHould return true, because it is impossible, but thinks its isoscales
	}
	
	@Test 
	public void impossibleTriangleValidArea(){
		assertEquals(-1, impossibleTriangle.getArea()); //Får NaN för den fattar inte den är impossible
	}
	
	@Test 
	public void impossibleTriangleValidPerimeter(){
		assertEquals(12, impossibleTriangle.getPerimeter());
	}
	
	@Test 
	public void impossibleTriangleValidSideLength(){
		assertEquals("1,1,10", impossibleTriangle.getSideLengths());
	}
	
	@Test 
	public void impossibleTriangleValidClassify(){
		assertEquals("Impossible", impossibleTriangle.classify());	//Get isosceles pga 2 same leg but should be impossiebe
	}

	@Test 
	public void isoscelesTriangleInValidisFalse() {
		assertFalse(isoscelesTriangleInvalid.isIsosceles());
	}
	
	@Test 
	public void isoscelesTriangleInvalidArea() {
		assertEquals(-1, isoscelesTriangleInvalid.getArea()); //Dose not woork get 0.0 which is wrong
	}
	
	@Test 
	public void isoscelesTriangleInvalidPerimeter() {
		assertEquals(-3, isoscelesTriangleInvalid.getPerimeter());
	}
	
	@Test 
	public void isoscelesTriangleInvalidSideLength(){
		assertEquals("-2,-2,1", isoscelesTriangleInvalid.getSideLengths());
	}
	
	@Test 
	public void isoscelesTriangleInvalidClassify(){
		assertEquals("impossible", isoscelesTriangleInvalid.classify());
	}
	
	
	@Test 
	public void scaleneTriangleInvalidisTrue(){
		assertFalse(scaleneTriangleInvalid.isScalene());
	}
	
	@Test 
	public void scaleneTriangleInvalidArea(){
		assertEquals(-1, scaleneTriangleInvalid.getArea()); //Dose not woork get 0.0 which is wrong
	}
	
	@Test 
	public void scaleneTriangleInvalidPerimeter(){
		assertEquals(-9, scaleneTriangleInvalid.getPerimeter());
	}
	
	@Test 
	public void scaleneTriangleInvalidSideLength(){
		assertEquals("-2,-3,-4", scaleneTriangleInvalid.getSideLengths());
	}
	
	@Test 
	public void scaleneTriangleInvalidClassify(){
		assertEquals("impossible", scaleneTriangleInvalid.classify());
	}
	
	
	@Test 
	public void impossibleInvalidisFalse(){
		assertTrue("Should return true for an impossible triangle", impossibleTriangleInvalid.isImpossible());
	}
	
	@Test 
	public void impossibleTriangleInvalidArea(){
		assertEquals(-1, impossibleTriangleInvalid.getArea()); //Får NaN för den fattar inte den är impossible
	}
	
	@Test 
	public void impossibleTriangleInvalidPerimeter(){
		assertEquals(-8, impossibleTriangleInvalid.getPerimeter());
	}
	
	@Test 
	public void impossibleTriangleInvalidSideLength(){
		assertEquals("1,1,-10", impossibleTriangleInvalid.getSideLengths());
	}
	
	@Test 
	public void impossibleTriangleInvalidClassify(){
		assertEquals("impossible", impossibleTriangleInvalid.classify());	//Get isosceles pga 2 same leg but should be impossiebe
	}
}