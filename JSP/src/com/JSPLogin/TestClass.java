package com.JSPLogin;

import com.JSPLogin.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;


public class TestClass {
	
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
	public void check()
	{
		String uname="Aniketh";
		String age="20";
		String city="Ahemedabad";
		String gender="Male";
		String password="bridgeit";
		assertEquals(true,Validate.Validation(uname, age, city, gender, password));
	}
	@Test
	public void checkdb()
	{
		assertNotNull(Utility.getcon("demo"));
	}
//	@Test
//	public void checkMock1()
//	{
//		HttpServletRequest request1=mock(HttpServletRequest.class);
//		HttpServletResponse response1=mock(HttpServletResponse.class);
//		RequestDispatcher rd=mock(RequestDispatcher.class);
//		
//		when(request1.getParameter("uname")).thenReturn("subbu");
//		when(request1.getParameter("password")).thenReturn("12");
//		when(request1.getRequestDispatcher("Login.html")).thenReturn(rd);
//		
//		try {
//		new Login1().doPost(request1, response1);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//		//assert
//		
//	}
	@Test
	public void checkMock()
	{
		HttpServletRequest request1=mock(HttpServletRequest.class);
		HttpServletResponse response1=mock(HttpServletResponse.class);
		
		when(request1.getParameter("uname")).thenReturn("");
		when(request1.getParameter("age")).thenReturn("100");
		when(request1.getParameter("city")).thenReturn("hyderabad");
		when(request1.getParameter("gender")).thenReturn("male");
		when(request1.getParameter("password")).thenReturn("bridgeit");
		
		try {
			new Signup().doPost(request1,response1);
			//verify(request1).getParameter("uname");
		} catch (ServletException e ) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
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
