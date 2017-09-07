package com.JSPLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public Signup() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("user");
		String age=request.getParameter("age");
		String city=request.getParameter("city");
		String gender=request.getParameter("gender");
		String password=request.getParameter("pass");
		int flag=0;
		System.out.println(uname);
		
		if(uname==null ||uname=="")
		{
		System.out.println("Invalid Username");
			out.println("Invalid Username");
			
		}
		else if(Integer.parseInt(age)>130 ||Integer.parseInt(age)<=0)
		{
			System.out.println("Enter a valid age");
			
		}
		else if(city==null ||city=="")
		{
			System.out.println("Invalid City");
		}
		else if(gender==null ||gender=="")
		{
			System.out.println("Invalid gender");
		}
		else if(password==null ||password=="")
		{
			System.out.println("Invalid password");
		}
		else
		{
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		String q1="insert into loginjsp values(?,?,?,?,?)";
		
		try {
			con=Utility.getcon("demo");
			System.out.println("Connection Established");
			ps=con.prepareStatement(q1);
			
			ps.setString(1,uname);
			ps.setInt(2,Integer.parseInt(age));
			ps.setString(3, city);
			ps.setString(4,gender);
			ps.setString(5, password);
			flag=ps.executeUpdate();
			System.out.println("Data added to database");
			out.println(" User Record added successfully now");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}  
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.close(con);
	}
		
		
		if(flag==0)
		{
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("Signup.html");
			rd.include(request, response);
		}
	}
	

}
