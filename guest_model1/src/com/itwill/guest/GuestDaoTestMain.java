package com.itwill.guest;


public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDaoImpl();
		
		//System.out.println(guestDao.selectAll());
		Guest gus1 = guestDao.selectByNo(5);
		//System.out.println(gus1);
		gus1.setGuest_name("김카스");
		guestDao.updateGuest(gus1);
		
		
	}

}
