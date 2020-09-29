package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestModifyFormServlet
 */
@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		/*
		1.파라메타바끼  guest_no
		2.GuestService.selectByNo()메쏘드호출
		3.Guest를 보여준다
		*/
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("guest_main.jsp");
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				GuestService guestService=new GuestService();
				Guest guest=
						guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		
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
