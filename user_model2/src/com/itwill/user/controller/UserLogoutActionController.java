package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserLogoutActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_main.do";
		}
		HttpSession session = request.getSession();
		session.invalidate();
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}
	
}
