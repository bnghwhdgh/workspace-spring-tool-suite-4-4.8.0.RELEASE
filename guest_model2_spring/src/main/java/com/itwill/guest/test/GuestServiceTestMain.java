package com.itwill.guest.test;

import com.itwill.guest.GuestServiceImpl;
import com.itwill.guest.GuestService;

public class GuestServiceTestMain {
	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestServiceImpl();
		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(1));
	}
}