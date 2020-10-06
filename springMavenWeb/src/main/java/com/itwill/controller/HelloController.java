package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public HelloController() {
		System.out.println("### 1. HelloController() 기본생성자 호출");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("### 2. HelloController.handleRequest() 메소드 호출");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/views/hello.jsp");
		request.setAttribute("msg", "ㅎㅇㅎㅇ");
		return mv;
	}

}
