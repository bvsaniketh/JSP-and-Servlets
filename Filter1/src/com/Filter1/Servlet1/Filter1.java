package com.Filter1.Servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter {
	
	public void init() {}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		out.println("Filter is invoked before");
		chain.doFilter(request, response);
		out.println("Filter is invoked after");
	}
	public void destroy() {}

}
