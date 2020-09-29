<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
		0. GET방식이면 guest_write_form.jsp redirection
		0 . 요청객체 인코딩설정
		1 . 파라메타받기 
			- 5개받기
		2 . Service객체 메쏘드호출(업무처리)
			- GuestService.insertGuest()
				3 . 요청클라이언트로 응답 
			- 성공:guest_main.jsp 로 redirection
			- 실패:guest_error.jsp로 redirection
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_write_form.jsp");
	}
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("guest_name");
	String email = request.getParameter("guest_email");
	String homepage = request.getParameter("guest_homepage");
	String title = request.getParameter("guest_title");
	String content = request.getParameter("guest_content");
	
	GuestService guSer = new GuestService();
	Guest inguest= new Guest(name,email,homepage,title,content);
	int insertRow = guSer.insertGuest(inguest);
	if(insertRow==1){
		response.sendRedirect("guest_list.jsp");
		return;
	}else{
		response.sendRedirect("guest_error.jsp");
	}
%>

