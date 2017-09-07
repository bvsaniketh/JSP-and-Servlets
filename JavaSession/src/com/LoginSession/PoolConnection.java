package com.LoginSession;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolConnection{
	
	static ComboPooledDataSource cpds=null;
	public  static void getPoolConnection() throws PropertyVetoException
	{
		if(cpds==null)
		{	
		cpds= new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
		cpds.setUser("root");
		cpds.setPassword("bridgeit");
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		System.out.println("hello mate");
		}
		
	}
	public static Connection PoolConnection1() throws SQLException, PropertyVetoException
	{
		getPoolConnection();
		return cpds.getConnection();
	}
}
