package com.StudentLogin1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentLogin
 */
public class StudentLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentLogin1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		ServletConfig config=getServletConfig();
		String value=config.getInitParameter("Institute");
		ServletContext ctx=getServletContext();
		String cval=ctx.getInitParameter("driver");
		String stu=request.getParameter("studname");
		String age=request.getParameter("age");
		String deg=request.getParameter("degree");
		String id=request.getParameter("id");
		String gen=request.getParameter("gender");
		System.out.println(stu + " " +age +" "+deg+" "+id+" "+gen );
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<html><body bgcolor=\"#00bfff\">");
		out.println("University name is : "+ value);
		out.println("Welcome "+stu +" of "+deg + "<br>");
		out.println("<a href=\"main.html\"> Click here to go back to Main Menu</a><br>"); 
		
		
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		String q1="insert into student values(?,?,?,?,?)";
		try {
			Class.forName(cval);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			System.out.println("Connection Established");
			ps=con.prepareStatement(q1);
			
			ps.setString(1,stu);
			ps.setInt(2,Integer.parseInt(age));
			ps.setString(3, deg);
			ps.setInt(4, Integer.parseInt(id));
			ps.setString(5, gen);
			ps.executeUpdate();
			System.out.println("Data added to database");
			out.println("Student Record added successfully");
			out.println("</body></html>");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 catch (SQLException e )
		{
			 e.printStackTrace();
		}
	
		
		
	
		
		
	}

}
