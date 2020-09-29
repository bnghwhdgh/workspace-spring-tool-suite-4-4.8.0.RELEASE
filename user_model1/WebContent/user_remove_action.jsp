<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로그인 한 사람만 이용할 수 있게끔 하는 지시-->
<%@include file="login_check.jspf" %>

<%
	try {
	String userId = request.getParameter("userId");
	UserService userService = new UserService();
	int removeRowCount = userService.removeUser(userId);
	if (userId.equals(sUserId)) {
		//로그인 한 사람일 경우 로그아웃
		response.sendRedirect("user_logout_action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
} catch (Exception e) {
	e.printStackTrace();
	response.sendRedirect("user_error.jsp");
}
%>