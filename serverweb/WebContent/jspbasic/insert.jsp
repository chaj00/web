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
	<!-- DeptŬ������ insert �޼ҵ带 ȣ���ؼ� ���� db�� insert�ɼ� �ֵ��� �����ϱ� 
		����۾��� ó���� �� ����ȭ��
		__�� �� ���Լ���!! or ���Խ���!!
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
			<h1><%= result+"�� �� ���� ����" %></h1>
		<% }else{%>
			<h1><%= "���� ����!!" %></h1>
		<%} %>
		
	
	

</body>
</html>