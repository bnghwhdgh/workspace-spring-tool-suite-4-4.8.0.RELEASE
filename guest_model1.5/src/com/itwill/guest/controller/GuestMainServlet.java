package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_main.do")
public class GuestMainServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="forward:/WEB-INF/views/guest_main.jsp"; 
		//서버 자원이 인클루드/포워딩시 web-inf 경로를 기술할 때 사용됨 
		//=>클라이언트는 절대로 .jsp 요청을 할 수가 없다.
		
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		
		
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
