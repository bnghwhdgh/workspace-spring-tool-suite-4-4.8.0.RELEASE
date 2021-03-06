package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath ="";
		if(request.getMethod().equalsIgnoreCase("GET")){
		forwardPath="redirect:guest_main.do";
		
	}else {
		try{
			//request.setCharacterEncoding("UTF-8"); web.xml에 필터 해둠
			String guest_name=request.getParameter("guest_name");
			String guest_email=request.getParameter("guest_email");
			String guest_homepage=request.getParameter("guest_homepage");
			String guest_title=request.getParameter("guest_title");
			String guest_content=request.getParameter("guest_content");
			Guest guest=
					new Guest(-999,guest_name,
							  null,guest_email,
							  guest_homepage,guest_title,
							  guest_content);
			GuestService guestService=new GuestService();
			int insertRowCount=
					guestService.insertGuest(guest);
			forwardPath="rediect:guest_list.do";
			//response.sendRedirect("guest_list.do");
		}catch(Exception e){
			e.printStackTrace();
			//response.sendRedirect("guest_error.jsp");
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
	}
		return forwardPath;
	}

}
