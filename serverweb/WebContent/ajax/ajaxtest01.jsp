<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type ="text/javascript">
	function runAjax(){
		//step1. XMLHttpRequest��ü ����
		var xhr = new XMLHttpRequest();
		
		//step2. onreadystatechange�� ����
		mydiv = document.getElementById("mydiv");
		xhr.onreadystatechange = function(){
			console.log("���°�:"+xhr.readyState);
			if(xhr.readyState==4 & xhr.status==200){
				mydiv.innerHTML = xhr.responseText;
			}
		}
		//step3. ��û����
		xhr.open("GET", "idtest.jsp?id="+myform.id.value, true);
		
		//step4. ��û������
		xhr.send();
	}

</script>
</head>
<body>
	<h1>Ajax�׽�Ʈ</h1>
	<form name="myform">
		<input type="text" name="id">
	</form>
	<button type="button" onclick="runAjax()">Ajax�׽�Ʈ</button>
	<div id="mydiv"></div>
</body>
</html>