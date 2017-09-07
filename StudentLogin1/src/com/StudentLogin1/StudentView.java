package com.StudentLogin1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentView
 */
public class StudentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentView() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		ServletConfig config=getServletConfig();
		String def=config.getInitParameter("User");
		ServletContext ctx=getServletContext();
		String cval=ctx.getInitParameter("driver");
	
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<html><body bgcolor=\"#00bfff\">");
		out.println("<a href=\"main.html\"> Click here to go back to Main Menu</a><br>");
		out.println("<b>"+def+"</b>");
		
		
		Connection con=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int i=1;
		String q1="select * from student";
		try {
			Class.forName(cval);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=bridgeit");
			System.out.println("Connection Established");
			st=con.createStatement();
			rs=st.executeQuery(q1);
			
			while(rs.next())
			{	out.println("<fieldset>");
				out.println("Record"+i);
				out.println("Name "+rs.getString(1)+"<br>");
				out.println("Age "+rs.getInt(2)+"<br>");
				out.println("Degree " +rs.getString(3)+"<br>");
				out.println("ID " +rs.getInt(4)+"<br>");
				out.println("String "+rs.getString(5)+"<br>");
				System.out.println("Record " +i);
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				out.println("<br>");
				out.println("</fieldset>");
				i++;
			}
			
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
