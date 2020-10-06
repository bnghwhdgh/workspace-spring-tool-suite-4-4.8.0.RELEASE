package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트데이터");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_map.do")
	public String map(Map map) {
		//request.setAttribute("map", "맵데이터지롱"); 
		//이렇게 알아서 request에 붙는다 그렇기에 EL로 처리가 된당
		map.put("map", "맵데이터지롱");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_model.do")
	public String model(Model model) {
		model.addAttribute("model", "모델데이터는 애드어트리뷰트");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap.do")
	public String modelMap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap", "모델맵 데이터는 애드어트리뷰트");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelandview.do")
	public ModelAndView modelview() {
		//ModelAndView => 객체를 생성하고 forward..?
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("modelAndView", "모델앤드뷰데이터지렁");
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp");
		return modelAndView;
	}
	@RequestMapping("/model_all.do")
	public String model_all(HttpServletRequest request, Model model, Map map, ModelMap modelMap){
		request.setAttribute("req", "리퀘스트데이터");
		map.put("map", "맵데이터지롱");
		model.addAttribute("model", "모델데이터는 애드어트리뷰트");
		modelMap.addAttribute("modelmap", "모델맵 데이터는 애드어트리뷰트");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
}
