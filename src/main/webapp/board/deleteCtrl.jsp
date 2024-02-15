<%@page import="srv.BoardService"%>
<%@page import="ioc.Factory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	//seq 처리 로직
	int seq = 0;

	String seq_ = request.getParameter("seq");
	if(!seq_.isEmpty()){
	  seq = Integer.valueOf(seq_);
	}
	
	BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
	boardSrv.delete(seq);
	
	response.sendRedirect("./list.jsp");
%>