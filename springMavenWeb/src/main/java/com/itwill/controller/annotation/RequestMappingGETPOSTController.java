package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingGETPOSTController {
	
	//url은 같으나 메소드에 따라 다르게 실행됨
	@RequestMapping(value = "login.do",method = RequestMethod.GET)
	public String login_form_get() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	@RequestMapping(value = "login.do",method = RequestMethod.POST)
	public String login_action_post(HttpServletRequest request,HttpSession session,@RequestParam String id,@RequestParam String password) {
		/*
		 *  <li>id 파라메타: ${param.id}</li>
			<li>password 파라메타: ${param.password}</li>
		 */
		System.out.println("### id parameter:"+id);
		System.out.println("### password parameter:"+password);
		boolean isLogin = true;
		if(isLogin) {
			session.setAttribute("id", id);
		}
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}
}
