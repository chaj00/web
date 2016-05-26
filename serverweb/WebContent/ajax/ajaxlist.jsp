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
		//step1. XMLHttpRequest객체 생성
		xhr = new XMLHttpRequest();
		
		//step2. onreadystatechange를 구현
		deptnodiv = document.getElementById("deptno");
		deptnamediv = document.getElementById("deptname");
		locdiv = document.getElementById("loc");
		telNumdiv = document.getElementById("telNum");
		
		xhr.onreadystatechange = test;
		//step3. 요청설정
		xhr.open("POST", "/serverweb/ajaxread.do", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//step4. 요청보내기
		xhr.send("deptno="+deptno);
		
		
	}
	function test(){
		console.log("상태값:"+xhr.readyState);
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
	<h1>부서 목록 조회하기</h1>
	<br/>
	<table border="1" width="600">
		<tr bgcolor="pink">
			<th>부서번호</th><th>부서이름</th><th>부서위치</th><th>전화번호</th><th>삭제</th>
		</tr>
	<%for(int i =0; i<list.size();i++){
			MyDeptDTO deptInfo = list.get(i);	%>
		<tr>
			<td><a href="javascript:runAjax('<%=deptInfo.getDeptno()%>')"><%= deptInfo.getDeptno()%></a></td>
			<td><%= deptInfo.getDeptname()%></td>
			<td><%= deptInfo.getLoc()%></td>
			<td><%= deptInfo.getTelNum() %></td>
			<td><a href="/serverweb/deptdelete.do?deptno=<%= deptInfo.getDeptno()%>">삭제</a></td>
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
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">부서코드</label>
						<div class="col-sm-3" id="deptno">
							<!-- 부서코드를 이곳에 출력하세요 -->
							
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- 부서명-->
						<label class="control-label col-sm-2" for="orgname">부서명</label>
						<div class="col-sm-3" id="deptname">
							<!-- 부서명을 이곳에 출력하세요 -->
						
						</div>
					</div>
				
					<div class="form-group">
						<!-- 부서위치-->
						<label class="control-label col-sm-2" for="orgloc">부서위치</label>
						<div class="col-sm-3" id="loc">
							<!-- 부서위치를 이곳에 출력하세요 -->
							

						</div>
					</div>
					<div class="form-group">
						<!-- 전화번호-->
						<label class="control-label col-sm-2" for="orgtel">전화번호</label>
						<div class="col-sm-3" id="telNum">
							<!-- 부서전화번호를 이곳에 출력하세요 -->
							
						</div>
					</div>


					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="수정하기" class="btn btn-success"/>
						</div>
						<input type="button" value="삭제하기" class="btn btn-success"/>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>