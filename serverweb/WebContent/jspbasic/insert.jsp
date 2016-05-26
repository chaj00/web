<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="basic.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- Dept클래스의 insert 메소드를 호출해서 실제 db에 insert될수 있도록 구현하기 
		모든작업을 처리한 후 응답화면
		__개 행 삽입성공!! or 삽입실패!!
	-->
	
	<%
		request.setCharacterEncoding("euc-kr");
		
		String deptno = request.getParameter("deptno");
		String deptname = request.getParameter("deptname");
		String loc = request.getParameter("loc");
		String telnum = request.getParameter("telnum");
	
		Dept dept = new Dept();
		int result = dept.insert(deptno, deptname, loc, telnum);
	
		if(result>=1){ %>
			<h1><%= result+"개 행 삽입 성공" %></h1>
		<% }else{%>
			<h1><%= "삽입 실패!!" %></h1>
		<%} %>
		
	
	

</body>
</html>