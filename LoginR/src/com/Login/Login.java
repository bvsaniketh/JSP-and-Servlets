package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("user");
		String password=request.getParameter("password");
		if(password.equals("servlet"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		}
		else
		{	out.print("Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
			
		}
			
	}

}
