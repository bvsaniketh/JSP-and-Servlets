package com.LoginSession;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int age=Integer.parseInt(request.getParameter("age"));
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		JavaBean bean=new JavaBean();
		bean.setFirstname(fname);
		bean.setLastname(lname);
		bean.setage(age);
		bean.setUsername(uname);
		bean.setPassword(pass);
		
		try {
			JDBCRegister.login(bean);
			response.setContentType("text/html");
			out.println("Registered Successfully. You can login now");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
