package com.itwill.guest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		
		/**************************************************/
		try {
			GuestService guestService=new GuestService();
			ArrayList<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:guest_error.jsp";
		}
		/***************************************************/
		
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
