<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<div id="wrap">
		<h1>로그인</h1>
		<!-- http://localhost:8090/jsp_mvc2/loginCtrl -->
		<form action="${pageContext.request.contextPath}/loginCtrl" method="post">
			<fieldset>
				<legend>모델2 - 게시판</legend>
				
				<ul>
					<li>
						<label for="userid">아이디</label>
						<input type="text" id="userid" name="userid" value="duly">
					</li>
					<li>
						<label for="password">비빌번호</label>
						<input type="password" id="password" name="password" value="1234">
					</li>
				</ul>
			</fieldset>
			<p><button>확인</button></p>
		</form>
	</div>
</body>
</html>












