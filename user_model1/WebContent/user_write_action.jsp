<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.UserService"%>
<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		//scope객체?
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	User newUser=null;
	try{
	newUser = new User(userId,password,name,email);
	UserService userService = new UserService();
	int rowCount=userService.create(newUser);
	//rowCount가 성공하면 response.sendRedirect("user_login_form.jsp");
	response.sendRedirect("user_login_form.jsp");
	//rowCount가 실패하면 catch(ExistedUserException e) 로 넘어가게 됨
	}catch(ExistedUserException e){
		//e.printStackTrace();
		
		/*
		forward를 사용하는 경우 => 이동하려는 page로 데이터를 전달해야 할 때
		*/
		//forwoard는 주소의 변동이 없다. =>데이터만 전달해준다.
		
		/*
		<jsp:forward path="user_write_form.jsp"/>
		*/
		//19번째 라인의 newUser 객체의 정보가 "fuser"라는 이름으로 요청객체에 세팅이 됨.
		//request.setAttribute("fuser", newUser);
		//위의 설명과 마찬가지임
		//request.setAttribute("msg", e.getMessage());
		//RequestDispatcher rd = request.getRequestDispatcher("user_write_form.jsp");
		//rd.forward(request, response);
		/*************************************/
		/*
		<jsp:forward path="user_write_form.jsp"/>
		*/
		request.setAttribute("fuser", newUser);
		request.setAttribute("msg", e.getMessage());
		
		//user_write_form.jsp에서 fuser 와 msg를 사용할 수 있게 된다.
		RequestDispatcher rd=
				request.getRequestDispatcher("user_write_form.jsp");
		rd.forward(request, response);
		
		/*****************[정상응답]**********************/
		//out.println("<script>");
		//out.println("alert('"+e.getMessage()+"');");
		//out.println("location.href='user_write_form.jsp';");
		//out.println("</script>");
		/********************************************/
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>












