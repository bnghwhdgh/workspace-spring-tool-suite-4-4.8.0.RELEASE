package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.guest.GuestService;

public class GuestViewController implements Controller {
	private GuestService guestService;
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_view.do***********************/
		ModelAndView mv = new ModelAndView();
		String forwardPath="";
		String guest_noStr = request.getParameter("guest_no");
		if(guest_noStr==null||guest_noStr.equals("")){
			forwardPath="redirect:guest_list.do";
			mv.setViewName(forwardPath);
		}else {
			try {
				Guest guest=
						guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath="forward:/WEB-INF/views/guest_view.jsp?guest_no="+guest_noStr;
				mv.setViewName(forwardPath);
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				mv.setViewName(forwardPath);
			}
		}
		return mv;
	}

}
