package com.itwill.guest;

public class GuestServiceTestMain {

	public static void main(String[] args) throws Exception {
		GuestService guestService = new GuestService();
		//System.out.println(guestService.selectAll());
		Guest gus = guestService.selectByNo(27);
		gus.setGuest_homepage("qweqwrqr");
		guestService.updateGuest(gus);
		
		int deleteRow = guestService.deleteGuest(26);
		System.out.println(deleteRow);
	}

}
