package com.itwill1.bean.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext 객체생성
		 * -BeanFactory객체생성
		 * -Spring Container객체생성
		 */
		System.out.println("------------------------Spring Container 초기화 시작---------------------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill1/bean/annotation/1.bean-create-annotation.xml");
		System.out.println("------------------------Spring Container 초기화 끝---------------------------");
		System.out.println();
		System.out.println("---------------------scope[singleton] 실행시 한 번 초기화-----------------------");
		SingletonScopeBean singletonScopeBean1=(SingletonScopeBean)applicationContext.getBean("singletonBean");
		SingletonScopeBean singletonScopeBean2=(SingletonScopeBean)applicationContext.getBean("singletonBean");
		System.out.println(singletonScopeBean1);
		System.out.println(singletonScopeBean2);
		System.out.println();
		System.out.println("------------------------init-method, destroy-method-------------------------");
		DisposableBean context =(DisposableBean)applicationContext;
		context.destroy();
		
	}

}
