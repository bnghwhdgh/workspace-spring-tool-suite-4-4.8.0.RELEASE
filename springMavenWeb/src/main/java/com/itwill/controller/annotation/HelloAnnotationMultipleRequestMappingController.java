package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러 하나에 여러개의 요청을 매핑 할 수 있다.
@Controller
public class HelloAnnotationMultipleRequestMappingController {
	
	/*
	 * Servlet ---forward--> jsp
	 */
	//forwardPath 반환해줄 메소드
	//매핑작업을 해주자
	@RequestMapping("/hello3.do")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
		
	}
	@RequestMapping("/hello4.do")
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
		
	}
	@RequestMapping("/hello5.do")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
		
	}
	
	/*
	 * Servlet --redirect--> jsp
	 */
	@RequestMapping("/hello_redirect_jsp.do")
	public String hello_redirect_jsp() {
		//redirect => context root(webapp)
		//forward => /web-inf/views
		return "redirect:hello_redirected.jsp";
	}
	
	/*
	 * Servlet --redirect--> Servlet ---forward--> jsp
	 */
	@RequestMapping("/hello_redirect_servlet.do")
	public String hello_redirect_servlet() {
		return "redirect:hello_redirected_servlet.do";
	}
	@RequestMapping("/hello_redirected_servlet.do")
	public String hello_redirected_servlet() {
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}
	
	/*
	 * Servlet(*.do) ---forward--> Servlet(*.do)
	 */
	@RequestMapping("/hello_servlet_forward.do")
	public String hello_servlet_forward() {
		return "forward:hello_servlet_forwarded.do";
	}
	@RequestMapping("/hello_servlet_forwarded.do")
	public String hello_servlet_forwarded() {
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
	}
}
