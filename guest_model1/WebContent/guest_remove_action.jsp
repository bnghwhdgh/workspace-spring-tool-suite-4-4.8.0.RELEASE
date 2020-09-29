<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1.파라메타바끼 (quest_no)
	2.GuestService.deleteGuest()메쏘드호출
	3.성공 -->guest_list.jsp redirection
      실패 -->guest_error.jsp redirection
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
    try{
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("guest_no");
	    GuestService guestSer = new GuestService();
	    Guest guest = guestSer.selectByNo(Integer.parseInt(no));
	    int deleteRow=guestSer.deleteGuest(guest.getGuest_no());
	    response.sendRedirect("guest_list.jsp");
    }catch(Exception e){
    	e.printStackTrace();
    	response.sendRedirect("guest_error.jsp");
    }
%>
