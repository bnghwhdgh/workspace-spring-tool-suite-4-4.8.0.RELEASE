package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestServiceImpl;
import com.itwill.guest.GuestService;


public class GuestRemoveActionController implements Controller {
	private GuestService guestService;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_remove_action.do******************/
		ModelAndView mv = new ModelAndView();
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("guest_main.do");
			forwardPath="redirect:guest_main.do";
			mv.setViewName(forwardPath);
		}else {
		    try{
			    String guest_noStr = request.getParameter("guest_no");
			    guestService.deleteGuest(Integer.parseInt(guest_noStr));
			    //response.sendRedirect("guest_list.do");
			    forwardPath="redirect:guest_list.do";
			    mv.setViewName(forwardPath);
		    }catch(Exception e){
		    	e.printStackTrace();
		    	//response.sendRedirect("guest_error.do");
		    	forwardPath="redirect:guest_error.do";
		    	mv.setViewName(forwardPath);
		    }
		}
		return mv;
	}
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

}
