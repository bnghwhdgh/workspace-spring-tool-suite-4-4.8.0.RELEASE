<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	if(id==null)id="";
	String msg="";
	if(id.startsWith("guard")){
		msg="사용가능";
	}else{
		msg="불가능";
	}
	Thread.sleep(1000);
%>
<%=msg%>