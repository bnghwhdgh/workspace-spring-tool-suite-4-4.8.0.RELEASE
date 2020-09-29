package com.itwill.user.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;

public class UserWriteActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath = "redirect:user_write_form.do";
			//forwardPath = "redirect:user_write_form.jsp"; 클라이언트가 요구 할 수 없다!
		}else {
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			User newUser=null;
			try{
				newUser=new User(userId,password,name,email);
				UserService userService=new UserService();
				int rowCount = userService.create(newUser);
				forwardPath = "redirect:user_login_form.do";
			}catch(ExistedUserException e){
				request.setAttribute("fuser", newUser);
				request.setAttribute("msg", e.getMessage());
				forwardPath = "forward:/WEB-INF/views/user_write_form.jsp";

			}catch(Exception e){
				e.printStackTrace();
				//아래거는 둘 중 하나만 사용하면 된다.
				//forwardPath = "redirect:user_error.do";		
				forwardPath = "forward:/WEB-INF/views/user_error.jsp";		
			}
		}

		return forwardPath;
	}

}
