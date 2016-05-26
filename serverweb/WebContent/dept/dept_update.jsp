<%@page import="dept.dto.MyDeptDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <%
		MyDeptDTO dept = (MyDeptDTO)request.getAttribute("dept");
	%>
</head>
<body>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/deptupdate.do?deptno=<%=dept.getDeptno() %>" method="POST">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
					<div class="form-group">
						<!-- �μ��ڵ� -->
						<label class="control-label col-sm-2" for="orgcode">�μ��ڵ�</label>
						<div class="col-sm-3">
							<!-- �μ��ڵ带 �̰��� ����ϼ��� -->
							<%= dept.getDeptno() %>
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- �μ���-->
						<label class="control-label col-sm-2" for="orgname">�μ���</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="deptname"
								placeholder="�μ���" value=<%= dept.getDeptname() %>  class="form-control" minlength="4" required>

						</div>
					</div>


					
					<div class="form-group">
						<!-- �μ���ġ-->
						<label class="control-label col-sm-2" for="orgloc">�μ���ġ</label>
						<div class="col-sm-3">
							<input type="text" id="orgloc" name="loc"
								placeholder="�μ���ġ" value=<%= dept.getLoc() %> class="form-control" minlength="4" >

						</div>
					</div>
					<div class="form-group">
						<!-- ��ȭ��ȣ-->
						<label class="control-label col-sm-2" for="orgtel">��ȭ��ȣ</label>
						<div class="col-sm-3">
							<input type="text" id="orgtel" name="telNum" 
							placeholder="��ȭ��ȣ" value=<%= dept.getTelNum() %>
								class="form-control" minlength="4" required>

						</div>
					</div>


					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="����" class="btn btn-success"/>
							<input type="button" value="����" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>