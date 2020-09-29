package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";

		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_main.do";
		}else {
			try{
				String userId=request.getParameter("userId");
				String sUserId=(String) request.getAttribute("sUserId");
				UserService userService=new UserService();
				int removeRowCount=userService.remove(userId);
				forwardPath="redirect:user_main.do";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="redirect:user_error.do";
			}	
		}
		return forwardPath;
	}

}
