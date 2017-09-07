package com.JSPLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Utility {
	
	
	static Connection getcon(String dbname)
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname+"?user=root&password=bridgeit");
			System.out.println("jdbc:mysql://localhost:3306/\"+dbname+\"?user=root&password=bridgeit");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return con;
	}
	
	static void close(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
