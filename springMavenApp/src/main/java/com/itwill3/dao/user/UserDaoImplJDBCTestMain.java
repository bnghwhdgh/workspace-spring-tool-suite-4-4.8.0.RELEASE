package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-jdbc.xml");
		UserDao userDao=(UserDao)applicationContext.getBean(UserDao.class);
		System.out.println("### "+userDao.findUserList());
	}

}