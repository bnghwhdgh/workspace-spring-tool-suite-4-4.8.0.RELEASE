package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
		forwardPath="redirect:guest_main.do";
	}else {
	    try{
		    String guest_noStr = request.getParameter("guest_no");
		    GuestService guestService=new GuestService();
		    guestService.deleteGuest(Integer.parseInt(guest_noStr));
		    forwardPath="redirect:guest_list.do";
	    }catch(Exception e){
	    	e.printStackTrace();
	    	forwardPath="redirect:guest_error.do";
	    }
	}
		return forwardPath;
	}

}
