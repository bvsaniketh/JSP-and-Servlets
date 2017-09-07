package com.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import com.max.Maximum;
import org.junit.Test;


public class TestCase {
	
	@BeforeClass
	public static void setBeforeClass()
	{
		System.out.println("Before Class executed once");
	}
	
	@Before
	public void setBefore()
	{
		System.out.println("Before every test");
	}
	
	
	@Test
	public void TestLogic()
	{
	assertEquals(5,Maximum.findmax(new int[] {1,3,4,5,2}));
	assertEquals(8,Maximum.findmax(new int[] {6,3,4,8,1}));
	assertEquals(-1,Maximum.findmax(new int[] {-1,-12,-6,-4,-8}));
	assertEquals(125,Maximum.cube(5));
	}
	
	@Test
	public void TestLogic1()
	{
		assertEquals(125,Maximum.cube(5));
	}
	
	@AfterClass
	public static void setafterclass()
	{
		System.out.println("After class executed");
	}
	
	@After
	public void after()
	{
		System.out.println("After every test case");
	}
	
}
