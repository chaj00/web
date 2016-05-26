<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,dept.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<% //서블릿이 공유해준 데이터 꺼내기
	ArrayList<MyDeptDTO> deptlist = 
		(ArrayList<MyDeptDTO>)request.getAttribute("searchlist");

	%>
</head>
<body>
	<h1>부서목록 조회하기</h1>
	<hr/>
	<table border="1" width="600">
		<tr bgcolor="pink">
			<th>부서번호</th><th>부서명</th><th>위치</th>
			<th>전화번호</th><th>삭제</th>
		</tr>
		<%
		int size = deptlist.size();
		for(int i=0;i<size;i++){
			//ArrayList에 저장된 Dto하나 꺼내기
			MyDeptDTO deptInfo = deptlist.get(i);%>
			<tr>
				<td><%= deptInfo.getDeptno() %></td>
				<td><%= deptInfo.getDeptname() %></td>
				<td><%= deptInfo.getLoc() %></td>
				<td><%= deptInfo.getTelNum() %></td>
				<td><a href="/template/deptdelete.do?deptno=<%=deptInfo.getDeptno() %>">삭제</a></td>
			</tr>			
		<%}%>
	</table>
</body>
</html>
















