package com.itwill3.dao.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.user.UserDao;

public class UserDaoImplMybatisMapperInterfaceTestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-mybatis-mapper-interface.xml");
		UserDao userDao=(UserDao)applicationContext.getBean(UserDao.class);
		System.out.println("### "+userDao.findUserList());
	}

}
