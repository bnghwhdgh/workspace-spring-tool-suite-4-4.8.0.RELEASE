<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
1.파라메타바끼
2.GuestService.updateGuest()메쏘드호출
3.성공 -->guest_view.jsp?guest_no=67 redirection
  실패-->guest_error.jsp redirection
*/
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("guest_main.jsp");
		return;
	}
	try {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("guest_no");
		String name = request.getParameter("guest_name");
		String email = request.getParameter("guest_email");
		String homepage = request.getParameter("guest_homepage");
		String title = request.getParameter("guest_title");
		String content = request.getParameter("guest_content");
		GuestServiceImpl guestSer = new GuestServiceImpl();
		Guest guest = new Guest(Integer.parseInt(no), name, null, email, homepage, title, content);
		int updateRow = guestSer.updateGuest(guest);
		response.sendRedirect("guest_view.jsp?guest_no=" + no);
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("guest_error.jsp");
	}
%>

