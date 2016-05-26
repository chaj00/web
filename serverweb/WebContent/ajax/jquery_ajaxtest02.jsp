<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type ="text/javascript">
	
	//get방식일 경우
	$(document).ready(function(){
		$("#ajaxbtn").on("click", function(){
			$.get("idtest.jsp",{"id":$("#id").val()},success_run);
		});
	});
	 
	 function success_run(txt){//서버와 통신이 성공하면 처리결과를 success에 지정한 함수를 호출하며 넘겨준다.
		 
		 $("#mydiv").html("get:"+txt);
	 }
	 function err_run(obj,msg,statusMsg){
		 //obj :XMLHttpRequest 객체, msg:응답메세지, statusMsg:에러메세지
		 alert("오류발생"+obj+msg+statusMsg);
	 }

</script>
</head>
<body>
	<h1>Ajax테스트</h1>
	<form name="myform">
		<input type="text" id="id">
	</form>
	<button type="button" id="ajaxbtn">Ajax테스트</button>
	<div id="mydiv"></div>
</body>
</html>