package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserLoginActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_login_form.do";
		}else {
			String userId=null;
			String password=null;
			try{
				userId=request.getParameter("userId");
				password=request.getParameter("password");
				UserService userService=new UserService();
				User loginUser = userService.login(userId, password);
				//session객체는 request객체를 갖고 있으니 필요할 때 불러주자
				HttpSession session = request.getSession();
				//29번라인 없으면 에러 뜨지렁
				session.setAttribute("sUserId", userId);
				session.setAttribute("sUser", loginUser);
				forwardPath="redirect:user_main.do";
			}catch(UserNotFoundException e){
				request.setAttribute("msg1", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				//메시지를 전달해줘야 하기 때문에 리다이렉트를 하면 안 된다.
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
			}catch(PasswordMismatchException e){
				request.setAttribute("msg2", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";

			}catch(Exception e){
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	}

}
