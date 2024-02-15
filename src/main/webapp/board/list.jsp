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
		<h1>글목록</h1>
		
		<p>${name}님 환영합니다~!</p>
		
		<style>
			td{
				padding:0 15px;
				text-align:center;
			}
		</style>
		
		<table>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">닉네임</th>
					<th scope="col">등록일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
			
			  <c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.seq}</td>
					<td><a href="./readCtrl?seq=${dto.seq}">${dto.title}</a></td>
					<td>${dto.nickname}</td>
					<td>${dto.regdate}</td>
					<td>${dto.cnt}</td>
				</tr>
			  </c:forEach>
				
				
			</tbody>
		</table>
		
		<p><a href="./write.jsp">새글등록</a></p>
	</div>
</body>
</html>













