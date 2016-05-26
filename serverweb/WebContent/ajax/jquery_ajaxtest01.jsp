<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type ="text/javascript">
	/*
	 $.ajax()�� �Ű�����
	 url  : ajax�� ��û�� ���ҽ��� ���
	 type : ��û��� get or post
	 data : JSON������� �Ű�����(�Ķ����)�� �Է�
	 dataType : ajaxó�� ����� ���� Ÿ�� text, json, html, jsonp
	 success : ������ ��ſ� �������� ��� ȣ��
	 error : 
	*/
	
	$(document).ready(function(){
		$("#ajaxbtn").on("click", function(){
			$.ajax({
				"url":"idtest.jsp",
				"type":"get",
				"data":{"id":$("#id").val()},
				"dataType":"text",
				"success":success_run,
				"error":err_run
			});//ajax�� ó���ϴ� jquery�Լ�
		});
	});
	 
	 function success_run(txt){//������ ����� �����ϸ� ó������� success�� ������ �Լ��� ȣ���ϸ� �Ѱ��ش�.
		 
		 $("#mydiv").html("jquery"+txt);
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