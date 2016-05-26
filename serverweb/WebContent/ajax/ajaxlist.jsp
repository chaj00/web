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
<script type ="text/javascript">

	var xhr;
	function runAjax(deptno){
		//step1. XMLHttpRequest��ü ����
		xhr = new XMLHttpRequest();
		
		//step2. onreadystatechange�� ����
		deptnodiv = document.getElementById("deptno");
		deptnamediv = document.getElementById("deptname");
		locdiv = document.getElementById("loc");
		telNumdiv = document.getElementById("telNum");
		
		xhr.onreadystatechange = test;
		//step3. ��û����
		xhr.open("POST", "/serverweb/ajaxread.do", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//step4. ��û������
		xhr.send("deptno="+deptno);
		
		
	}
	function test(){
		console.log("���°�:"+xhr.readyState);
		if(xhr.readyState==4 & xhr.status==200){
			var dept = JSON.parse(xhr.responseText);
			deptnodiv.innerHTML = dept.deptno;
			deptnamediv.innerHTML = dept.deptname;
			locdiv.innerHTML = dept.loc;
			telNumdiv.innerHTML = dept.telNum;
			
		}
		
	}

</script>	
</head>
<body>
	<h1>�μ� ��� ��ȸ�ϱ�</h1>
	<br/>
	<table border="1" width="600">
		<tr bgcolor="pink">
			<th>�μ���ȣ</th><th>�μ��̸�</th><th>�μ���ġ</th><th>��ȭ��ȣ</th><th>����</th>
		</tr>
	<%for(int i =0; i<list.size();i++){
			MyDeptDTO deptInfo = list.get(i);	%>
		<tr>
			<td><a href="javascript:runAjax('<%=deptInfo.getDeptno()%>')"><%= deptInfo.getDeptno()%></a></td>
			<td><%= deptInfo.getDeptname()%></td>
			<td><%= deptInfo.getLoc()%></td>
			<td><%= deptInfo.getTelNum() %></td>
			<td><a href="/serverweb/deptdelete.do?deptno=<%= deptInfo.getDeptno()%>">����</a></td>
		</tr>
		<%}%>

	</table>
	
	<br/>
	<br/>
	
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/deptread.do?deptno=&state=UPDATE" method="POST">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
					<div class="form-group">
						<!-- �μ��ڵ� -->
						<label class="control-label col-sm-2" for="orgcode">�μ��ڵ�</label>
						<div class="col-sm-3" id="deptno">
							<!-- �μ��ڵ带 �̰��� ����ϼ��� -->
							
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- �μ���-->
						<label class="control-label col-sm-2" for="orgname">�μ���</label>
						<div class="col-sm-3" id="deptname">
							<!-- �μ����� �̰��� ����ϼ��� -->
						
						</div>
					</div>
				
					<div class="form-group">
						<!-- �μ���ġ-->
						<label class="control-label col-sm-2" for="orgloc">�μ���ġ</label>
						<div class="col-sm-3" id="loc">
							<!-- �μ���ġ�� �̰��� ����ϼ��� -->
							

						</div>
					</div>
					<div class="form-group">
						<!-- ��ȭ��ȣ-->
						<label class="control-label col-sm-2" for="orgtel">��ȭ��ȣ</label>
						<div class="col-sm-3" id="telNum">
							<!-- �μ���ȭ��ȣ�� �̰��� ����ϼ��� -->
							
						</div>
					</div>


					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="�����ϱ�" class="btn btn-success"/>
						</div>
						<input type="button" value="�����ϱ�" class="btn btn-success"/>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>