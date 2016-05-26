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
	int dan = Integer.parseInt(request.getParameter("dan"));
	
	for(int i =1; i<=9;i++){%>
	<h3><%=dan %> * <%=i %> = <%=dan*i %></h3>	
	<%} %>	
	<%-- <!-- 강사님코드 -->
	<% 
		String dan =request.getParameter("dan");
		StringBuffer sb = new StringBuffer();
		int val = Integer.parseInt(dan);
		for(int i=1;i<=9;i++){
			sb.append(String.format("%d * %d = %d<br/>",val,i,(val*i)));
		}
		out.write(sb.toString());
	%> --%>


</body>
</html>