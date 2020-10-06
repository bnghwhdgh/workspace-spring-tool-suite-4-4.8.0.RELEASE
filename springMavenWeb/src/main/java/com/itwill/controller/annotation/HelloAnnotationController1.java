package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//이렇게 하면 Controller 객체가 생성된다
@Controller
public class HelloAnnotationController1 {
	
	public HelloAnnotationController1() {
		System.out.println("### HelloAnnotationController1() 기본생성자 생성");
	}
	//요청매핑=>url을 적는다
	@RequestMapping("/hello1.do")
	public String hello1(HttpServletRequest request) {
		System.out.println("### HelloAnnotationController1: hello1() 메소드 실행 생성");
		request.setAttribute("msg", "안녕HelloAnnotationController1");
		return "forward:/WEB-INF/views/hello1.jsp";
	}
}
