package com.LoginSession;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	static Connection con=null;
	static Statement stmt=null;
	static ResultSet rs= null;
	
	public static JavaBean login(JavaBean bean) throws PropertyVetoException
	{
	
		String user2=bean.getUsername();
		String pass2=bean.getPassword();
		String query="select * from details where username='"+user2+"' and password='"+pass2+"'";
		System.out.println(user2+" "+pass2+" "+ query);
		
		
		try {
			con=PoolConnection.PoolConnection1();
			System.out.println(con);
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			boolean more=rs.next();
			
			if(!more)
			{
				System.out.println("Invalid User Sign up first");
				bean.setValid(false);
			}
			else if(more)
			{
				String fname=rs.getString(1);
				String lname=rs.getString(2);
				int age=rs.getInt(3);
				System.out.println("Welcome " + fname);
				bean.setFirstname(fname);
				bean.setLastname(lname);
				bean.setage(age);
				bean.setUsername(user2);
				bean.setValid(true);
			}
		}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bean;
		
	}
	
}
