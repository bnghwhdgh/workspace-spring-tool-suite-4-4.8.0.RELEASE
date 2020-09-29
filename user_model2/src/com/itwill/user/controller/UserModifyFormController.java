package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;



public class UserModifyFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_main.do";
		}else {
			try {
				String userId=request.getParameter("userId");
				UserService userService=new UserService();
				User user=userService.findUser(userId);
				request.setAttribute("user", user);
				forwardPath="forward:/WEB-INF/views/user_modify_form.jsp";
				
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	}

}
