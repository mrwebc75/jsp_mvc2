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
		<h1>모델2 - 게시판</h1>
		
		<p><a href="./board/login.jsp">로그인</a></p>
		
		<p>
			<a href="/logoutCtrl">로그아웃</a> <br>
			<a href="./board/listCtrl">글목록</a> <br>
			<a href="./board/write.jsp">글쓰기</a> <br>
		</p>
	</div>
</body>
</html>