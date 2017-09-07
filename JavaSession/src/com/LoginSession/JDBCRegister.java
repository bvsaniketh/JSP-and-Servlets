package com.LoginSession;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class JDBCRegister {

	static Connection con=null;
	static Statement stmt=null;
	static ResultSet rs= null;
	static PreparedStatement ps=null;
	
	public static void login(JavaBean bean) throws PropertyVetoException
	{
		
		String fname2=bean.getFirstname();
		String lname2=bean.getLastname();
		int age=bean.getage();
		String user2=bean.getUsername();
		String pass2=bean.getPassword();
		pass2=PasswordEncryption.encrypt(pass2);
		System.out.println(pass2);
		String query="insert into details values(?,?,?,?,?)";
		System.out.println(user2+" "+pass2+" "+ query);
		
		
		try {
			con=PoolConnection.PoolConnection1();
			System.out.println(con);
			//stmt=con.createStatement();
			//rs=stmt.executeQuery(query);
			ps=con.prepareStatement(query);
			ps.setString(1, fname2);
			ps.setString(2, lname2);
			ps.setInt(3, age);
			ps.setString(4, user2);
			ps.setString(5, pass2);
			int flag=ps.executeUpdate();
			System.out.println("Data added to database");
			
//			out.println(" User Record added successfully now");
//			boolean more=rs.next();
//			
//			if(!more)
//			{
//				System.out.println("Invalid User Sign up first");
//				bean.setValid(false);
//			}
//			else if(more)
//			{
//				String fname=rs.getString(1);
//				String lname=rs.getString(2);
//				int age=rs.getInt(3);
//				System.out.println("Welcome " + fname);
//				bean.setFirstname(fname);
//				bean.setLastname(lname);
//				bean.setage(age);
//				bean.setUsername(user2);
//				bean.setValid(true);
//			}
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
		//return bean;
		
	}
	
}
