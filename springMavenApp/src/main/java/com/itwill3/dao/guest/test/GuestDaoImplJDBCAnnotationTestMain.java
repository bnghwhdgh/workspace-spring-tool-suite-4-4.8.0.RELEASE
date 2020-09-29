package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;

public class GuestDaoImplJDBCAnnotationTestMain {

	public static void main(String[] args) throws Exception{
		//applicationContext => 컨테이너!!
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/guest/guest-dao-jdbc-annotation.xml");
		applicationContext.getBean(GuestDao.class);
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println("------------------------------------------------");
		System.out.println("### "+guestDao);
		System.out.println("----------findGuestList----------");
		System.out.println(guestDao.selectAll());
		System.out.println(guestDao.selectByNo(1));
	}

}
