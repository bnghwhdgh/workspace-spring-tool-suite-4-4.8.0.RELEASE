<%@page import="com.itwill.user.UserService"%>
<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	try{
	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	User user = new User(userId,password,name,email);
	UserService userService = new UserService();
	int updateRowCount=userService.updateUser(user);
	response.sendRedirect("user_view.jsp?=userId="+userId);
	}catch(Exception e){
		e.printStackTrace();
		
	}
%>