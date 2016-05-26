<%@page import="dept.dto.MyDeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<MyDeptDTO> list = (ArrayList<MyDeptDTO>)request.getAttribute("searchlist");
	%>
	<table border=1 style='border-collapse:collapse' >
		<tr>
			<th>부서번호</th><th>부서이름</th><th>부서위치</th><th>전화번호</th><th>삭제</th>
		</tr>
	<%for(int i =0; i<list.size();i++){%>
		<tr>
			<td><%= list.get(i).getDeptno()%></td>
			<td><%= list.get(i).getDeptname()%></td>
			<td><%= list.get(i).getLoc()%></td>
			<td><%= list.get(i).getTelNum() %></td>
			<td><a href="/serverweb/deptdelete.do?deptno=<%= list.get(i).getDeptno()%>">삭제</a></td>
		</tr>
	<%}%>

	</table>
</body>
</html>