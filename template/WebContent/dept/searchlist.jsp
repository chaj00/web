<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,dept.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<% //������ �������� ������ ������
	ArrayList<MyDeptDTO> deptlist = 
		(ArrayList<MyDeptDTO>)request.getAttribute("searchlist");

	%>
</head>
<body>
	<h1>�μ���� ��ȸ�ϱ�</h1>
	<hr/>
	<table border="1" width="600">
		<tr bgcolor="pink">
			<th>�μ���ȣ</th><th>�μ���</th><th>��ġ</th>
			<th>��ȭ��ȣ</th><th>����</th>
		</tr>
		<%
		int size = deptlist.size();
		for(int i=0;i<size;i++){
			//ArrayList�� ����� Dto�ϳ� ������
			MyDeptDTO deptInfo = deptlist.get(i);%>
			<tr>
				<td><%= deptInfo.getDeptno() %></td>
				<td><%= deptInfo.getDeptname() %></td>
				<td><%= deptInfo.getLoc() %></td>
				<td><%= deptInfo.getTelNum() %></td>
				<td><a href="/template/deptdelete.do?deptno=<%=deptInfo.getDeptno() %>">����</a></td>
			</tr>			
		<%}%>
	</table>
</body>
</html>
















