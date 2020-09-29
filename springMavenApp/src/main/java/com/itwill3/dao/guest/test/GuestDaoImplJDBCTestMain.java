package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;

public class GuestDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/guest/guest-dao-jdbc.xml");
		applicationContext.getBean(GuestDao.class);
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println("------------------------------------------------");
		System.out.println("### "+guestDao);
		System.out.println("----------findGuestList----------");
		System.out.println(guestDao.selectAll());
	}

}
