<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type ="text/javascript">
	
	//get����� ���
	$(document).ready(function(){
		$("#ajaxbtn").on("click", function(){
			$.get("idtest.jsp",{"id":$("#id").val()},success_run);
		});
	});
	 
	 function success_run(txt){//������ ����� �����ϸ� ó������� success�� ������ �Լ��� ȣ���ϸ� �Ѱ��ش�.
		 
		 $("#mydiv").html("get:"+txt);
	 }
	 function err_run(obj,msg,statusMsg){
		 //obj :XMLHttpRequest ��ü, msg:����޼���, statusMsg:�����޼���
		 alert("�����߻�"+obj+msg+statusMsg);
	 }

</script>
</head>
<body>
	<h1>Ajax�׽�Ʈ</h1>
	<form name="myform">
		<input type="text" id="id">
	</form>
	<button type="button" id="ajaxbtn">Ajax�׽�Ʈ</button>
	<div id="mydiv"></div>
</body>
</html>