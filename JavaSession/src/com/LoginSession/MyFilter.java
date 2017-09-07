package com.LoginSession;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException{}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException
	{
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		System.out.println("Hi");
		PrintWriter out=response.getWriter();
		out.println("Filter is invoked before");
		response.setContentType("text/html");
		if(user.equals(""))
		{	
			out.println("Username is empty. Please enter a username");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else if(pass=="")
		{
			out.println("Password is empty. Please enter a password");
			request.getRequestDispatcher("index.jsp").include(request,response);
		}
		
		else {	
		
		chain.doFilter(request,response);
		out.println("Filter is invoked after");
		}
	}
	
	public void destroy() {}
}
