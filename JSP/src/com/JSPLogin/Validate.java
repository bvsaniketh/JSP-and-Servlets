package com.JSPLogin;

public class Validate {

	public static  boolean Validation(String uname,String age,String city,String gender,String password)
	{
	if(uname==null ||uname=="")
	{
		System.out.println("Invalid Username");
		return false;
	}
	else if(Integer.parseInt(age)>130 ||Integer.parseInt(age)<=0)
	{
		System.out.println("Enter a valid age");
		return false;
		
	}
	else if(city==null ||city=="")
	{
		System.out.println("Invalid City");
		return false;
	}
	else if(gender==null ||gender=="")
	{
		System.out.println("Invalid gender");
		return false;
	}
	else if(password==null ||password=="")
	{
		System.out.println("Invalid password");
		return false;
	}
	else
	{
		return true;
	}
}
}
