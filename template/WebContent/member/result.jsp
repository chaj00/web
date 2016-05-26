<%@page import="emp.dto.MyEmpDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% MyEmpDTO user = (MyEmpDTO) session.getAttribute("loginuser"); %>
	<h3><%= user.getName() %>(<%= user.getId() %>)님 로그인 성공</h3>
	<h4><a href="/template/member/email.jsp">메일읽기</a></h4>
</body>
</html>