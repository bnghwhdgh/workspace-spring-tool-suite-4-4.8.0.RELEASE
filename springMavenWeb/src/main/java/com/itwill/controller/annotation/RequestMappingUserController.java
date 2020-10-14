package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//public class RequestMappingUserController {
//	@RequestMapping("/user/list.do")
//	public String list() {
//		return "forward:/WEB-INF/views/user/list.jsp";
//	}
//	@RequestMapping("/user/view.do")
//	public String view() {
//		return "forward:/WEB-INF/views/user/list.jsp";
//	}
	/*
	 * RequestMapping 에서 /user가 계속 겹치니까 아래 형식으로 만들자
	 */
//}

@Controller
@RequestMapping("/user")
public class RequestMappingUserController{
	@RequestMapping("/list.do")
	public String list() {
		return "forward:/WEB-INF/views/user/list.jsp";
	}
	@RequestMapping("/view.do")
	public String view() {
		return "forward:/WEB-INF/views/user/view.jsp";
	}
}