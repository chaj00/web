<%@page import="emp.dto.MyEmpDTO"%>
<%@page import="dept.dto.MyDeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<%
		ArrayList<MyDeptDTO> list = (ArrayList<MyDeptDTO>)request.getAttribute("list");
		
	%>
	
</head>
<body>

	<table border="1" width="600">
		<tr bgcolor="pink">
			<th>�μ���ȣ</th><th>�μ��̸�</th><th>�μ���ġ</th><th>��ȭ��ȣ</th><th>����</th>
		</tr>
	<%for(int i =0; i<list.size();i++){
			MyDeptDTO deptInfo = list.get(i);	%>
		<tr>
			<td><%= deptInfo.getDeptno()%></td>
			<td><a href="/serverweb/deptread.do?deptno=<%= deptInfo.getDeptno()%>&state=READ"><%= deptInfo.getDeptname()%></a></td>
			<td><%= deptInfo.getLoc()%></td>
			<td><%= deptInfo.getTelNum() %></td>
			<td><a href="/serverweb/deptdelete.do?deptno=<%= deptInfo.getDeptno()%>">����</a></td>
		</tr>
		<%}%>

	</table>
</body>

</html>