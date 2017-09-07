

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


public class JunitTest {

	@Test
	public void check() throws ServletException, IOException
	{
		HttpServletRequest request1=mock(HttpServletRequest.class);
		HttpServletResponse response1=mock(HttpServletResponse.class);
		RequestDispatcher rd=mock(RequestDispatcher.class);

		when(request1.getParameter("user")).thenReturn("adhi");
		when(request1.getParameter("pass")).thenReturn("acade");
		//when(request1.getRequestDispatcher("Login.html")).thenReturn(rd);
		
		new Login1().doPost(request1, response1);

	}
}