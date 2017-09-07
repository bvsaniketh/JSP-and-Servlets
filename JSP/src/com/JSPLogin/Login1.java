package com.JSPLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Login1() {
        System.out.println("hi");// TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("user");
		String password=request.getParameter("pass");
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String q1="select * from loginjsp";
		String user1;
		String pass1;
		int flag=0;
		
		
		try {
			con=Utility.getcon("demo");
			System.out.println("Connection Established");
			st=con.createStatement();
			rs=st.executeQuery(q1);
			Cookie ck=new Cookie("user","anibo");
			while(rs.next())
			{
				flag=0;
				user1=rs.getString(1);
				pass1=rs.getString(5);
				if(user1.equals(uname) && pass1.equals(password))
				
				{	
					out.println("User details");
					out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					System.out.println("User details");
					System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					flag=1;
					System.out.println("Login successful");
					break;
				}	
				
				
			}
			if(flag==0)
			{
				response.setContentType("text/html");
				out.print("Invalid Credentials");
				System.out.println("Invalid Login");
				RequestDispatcher rd =request.getRequestDispatcher("Login.html");
				rd.include(request,response);
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.close(con);
	}
		
}
