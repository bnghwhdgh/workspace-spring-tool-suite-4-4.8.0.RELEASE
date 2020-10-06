package com.itwill.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	@RequestMapping("/guest_list.do")
	public String guest_list() {
		
		return "forward:/WEB-INF/views/guest_list.jsp";
	}
	
}
