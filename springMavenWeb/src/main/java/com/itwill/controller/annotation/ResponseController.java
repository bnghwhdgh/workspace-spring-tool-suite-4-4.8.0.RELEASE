package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ResponseController {
	/********************forward view********************/
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		//<<빈의 이름에 forward:가 없을 경우>>
		/* 
		  0 . response_view_name() 호출되면 view name(String)을 반환
		  1 . view name(String)을 반환 받은 디스패처 서블릿의 요청에 의해 
		  	  InternalResourceViewResolver 객체가 name에 해당하는 InternalResourceView를 검색해봄
		  2 . 해당하는 view가 빈팩토리에 없으면 InternalResourceView 객체(URL:/WEB-INF/views/response_view_name.jsp) 를 만들어버림
		  3 . URL을 세팅해서 --> 디스패처 서블릿이 render 메소드를 실행해서 /WEB-INF/views/response_view_name.jsp로  forward	
		*/
		
		//return "forward:/WEB-INF/views/response_view_name.jsp"; forward =>internalresouceview를 안탐
		//return "/WEB-INF/views/response_view_name.jsp";
		/*****************************************************************/
		/* 
		 << 빈의 이름에 forward:가 없을경우 >>
		 
		  0 . view name[String(/WEB-INF/views/response_view_name.jsp)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewResolver객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (설정에 prefix,suffix가 존재하면 설정된다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 /WEB-INF/views/response_view_name.jsp로 forward된다.
		      	
		  << 빈의 이름에 forward: 가있을경우 >> Servlet -----forward----> Servlet
		      
		  0 . view name[String(forward:xxx.do)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewr객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (설정XML에 prefix,suffix가 존재하면 설정된다)
		      (설정XML에 prefix,suffix가 존재 안하면 설정되지 않는다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 xxx.do로 forward된다.     
		      
		*/
		/*
		web-application-context-view-resolver.xml
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
		 */
		//return "forward:/WEB-INF/views/response_view_name.jsp";
		return "response_view_name";
	}
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		InternalResourceView internalResourceView =new InternalResourceView();
		//setUrl에는 forward를 붙이면 안 된다.
		internalResourceView.setUrl("/WEB-INF/views/response_view_object.jsp");
		 //String==> forward:/WEB-INF/views/response_view_object.jsp
		/*
		 * 1.InternalResourceView 객체(URL:/WEB-INF/views/response_view_object.jsp)반환
		 * 2.URL--> URL 세팅한곳(/WEB-INF/views/response_view_object.jsp) 로 forward시킨다
		 */
		return internalResourceView;
	}
	
	/********************redirect view********************/
	@RequestMapping("response_redirect_view_name.do")
	public String response_redirect_view_name(Model model) {
		model.addAttribute("id","guard");
		model.addAttribute("name","kim");
		/*
		 * response_redirect_view_name.do?id=guard&name=kim
		 */
		//redirect: 안붙이는 경우엔 forward가 된다. 그러니 반드시 적어야 한다.
		return "redirect:response_redirect_view_name.jsp";
	}
	@RequestMapping("response_redirect_view_object.do")
	public View response_redirect_view_object(Model model) {
		model.addAttribute("id","guard");
		model.addAttribute("name","kim");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("response_redirect_view_name.jsp");
		return redirectView;
	}
	
	
	
	
	
	
}
