<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type ="text/javascript">
	function runAjax(){
		//step1. XMLHttpRequest객체 생성
		var xhr = new XMLHttpRequest();
		
		//step2. onreadystatechange를 구현
		mydiv = document.getElementById("mydiv");
		xhr.onreadystatechange = function(){
			console.log("상태값:"+xhr.readyState);
			if(xhr.readyState==4 & xhr.status==200){
				mydiv.innerHTML = xhr.responseText;
			}
		}
		//step3. 요청설정
		xhr.open("GET", "idtest.jsp?id="+myform.id.value, true);
		
		//step4. 요청보내기
		xhr.send();
	}

</script>
</head>
<body>
	<h1>Ajax테스트</h1>
	<form name="myform">
		<input type="text" name="id">
	</form>
	<button type="button" onclick="runAjax()">Ajax테스트</button>
	<div id="mydiv"></div>
</body>
</html>