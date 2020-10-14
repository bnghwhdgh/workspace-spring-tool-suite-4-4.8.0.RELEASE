package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	//@Qualifier("guestService") id로 인잭션 => 없으면 타입으로 인잭션
	private GuestService guestService;
	
	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "guest_write_form";
	}
	@RequestMapping(value = "/guest_write_action.do",method = RequestMethod.GET)
	public String guest_write_action_get() {
		return "guest_write_form";
	}
	@RequestMapping(value = "/guest_write_action.do",method = RequestMethod.POST)
	public String guest_write_action_post(@ModelAttribute Guest guest) throws Exception{
		String forwardPath="";
		int insertRowCount = guestService.insertGuest(guest);
		forwardPath="redirect:guest_list.do";
		return forwardPath;
	}
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "guest_main";
	}
	@RequestMapping("/guest_list.do")
	public String guest_list(Model model) throws Exception{
		String forwardPath="";
		//컨트롤러가 디스패처서블릿에게 예외를 던지면 안된다.
		List<Guest> guestList=guestService.selectAll();
		model.addAttribute("guestList",guestList);
		forwardPath="guest_list";
		return forwardPath;
	}
	@RequestMapping("/guest_view.do")
	public String guest_view(Model model, @RequestParam String guest_no) throws Exception {
		String forwardPath="";
		Guest guest=
				guestService.selectByNo(Integer.parseInt(guest_no));
		model.addAttribute("guest", guest);
		forwardPath="guest_view";
		return forwardPath;
	}
	
	@RequestMapping(value = "/guest_modify_form.do", method = RequestMethod.GET)
	public String guest_modify_form_get() {
		String forwardPath="guest_modify_form";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_form.do", method = RequestMethod.POST)
	public String guest_modify_form_post(Model model,@RequestParam String guest_no) throws Exception{
		String forwardPath="";
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		model.addAttribute("guest", guest);
		forwardPath="guest_modify_form";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_action.do", method = RequestMethod.GET)
	public String guest_modify_action_get() {
		String forwardPath="guest_modify_form";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_action.do",method = RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute Guest guest, @RequestParam String guest_no) throws Exception{
		String forwardPath="";
		int updateRowCount = guestService.updateGuest(guest);
		forwardPath="redirect:guest_view.do?guest_no="+guest_no;
		return forwardPath;
	}
	@RequestMapping(value = "/guest_remove_action.do", method = RequestMethod.GET)
	public String guest_remove_action_get(@RequestParam String guest_no) {
		String forwardPath="redirect:guest_main.do";
		
		return forwardPath;
	}
	@RequestMapping(value = "/guest_remove_action.do", method = RequestMethod.POST)
	public String guest_remove_action_post(@RequestParam String guest_no ) throws Exception{
		String forwardPath = "";
		int deleteRowCount = guestService.deleteGuest(Integer.parseInt(guest_no));
		forwardPath = "redirect:guest_view.do?guest_no="+guest_no;
		forwardPath="guest_list";
		return forwardPath;
	}
	
	//모든 Exception을 던지면 이곳으로 날라온다
	@ExceptionHandler(Exception.class)
	public String guest_error_handle(Exception e) {
		return "guest_error";
	}
	
}
