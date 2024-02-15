<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.UserDTO"%>
<%@page import="srv.UserService"%>
<%@page import="ioc.Factory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!-- 로그인 승인을 처리하는 로직 -> 화면디자인이(View가) 필요없다. -->


<%
	//filter를 적용하여 아래 코드 생략함
	//request.setCharacterEncoding("utf-8");	

	//사용자가 입력한 데이터 수신
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	Map<String,String> loginInfo = new HashMap<String,String>();
	loginInfo.put("userid",userid);
	loginInfo.put("password",password);
	
/*
	select * from user where userid=#{userid} and password=#{password}
	위의 쿼리문을 dao가 mybatis를 이용해서 실행 -> 결과리턴 UserVO
	
	srv객체가 dao를 통해서 조회부탁
	
	컨트롤러에서 srv에 loginInfo를 넘기면서 부탁

*/
	
	//DB에 조회요청
	//어떤서비스객체.메소드(loginInfo);
	UserService userSrv = Factory.INSTANCE.getUserSrv();
	UserDTO dto = userSrv.getOne(loginInfo);

	if(dto!=null){//로그인 성공
	  session.setAttribute("userid", dto.getUserid());
	  session.setAttribute("name", dto.getName());
	  
	  response.sendRedirect("./list.jsp");
	}else{//로그인 실패
	  response.sendRedirect("../index.jsp");
	}
%>









