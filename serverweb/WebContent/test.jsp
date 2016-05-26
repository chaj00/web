<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charget=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charget=EUC-KR">
<title>Insert title here</title>
	<% 	
		String test = (String)request.getAttribute("test");
		 ArrayList<String> title = (ArrayList<String>)request.getAttribute("title"); 
		 /*			ArrayList<String> head = (ArrayList<String>)request.getAttribute("head");
		ArrayList<String> value = (ArrayList<String>)request.getAttribute("value");
		ArrayList<String> change = (ArrayList<String>)request.getAttribute("change");
		ArrayList<String> flucuation = (ArrayList<String>)request.getAttribute("flucuation"); */	
	%>
</head>
<body>
	<h1><%=test %></h1>
	<%-- <h1><%= title.get(0)%></h1>
	<h1><%= head.get(0)%></h1>
	<h1><%= value.get(0)%></h1>
	<h1><%= change.get(0)%></h1>
	<h1><%= flucuation.get(0)%></h1> --%>
</body>
</html>