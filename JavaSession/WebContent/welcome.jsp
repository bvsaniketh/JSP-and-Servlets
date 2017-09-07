<%@page import="com.LoginSession.JavaBean"%>
<%@include file="logout.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="com.LoginSession.JavaBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

JavaBean bean;
bean = (JavaBean)request.getAttribute("CurrentSessionUser"); 

%>

<center>
<fieldset>


<% if(bean!=null)
{
	
%>Welcome <br><br>
<b><%=bean.getUsername() %> </b>
<br><br>
<%=(bean.getFirstname())%> <%= (bean.getLastname())%>
<br><br>
<%=bean.getage() %>
<br> <% %>
</fieldset>
<a href="log">Logout</a>
<% 
}

else
	{
	response.sendRedirect("index.jsp");
	}
%>
</center>
</body>
</html>