package com.itwill3.dao;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataSourceApplicationContextMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext 객체생성
		 * -BeanFactory객체생성
		 * -Spring Container객체생성
		 */
		System.out.println("------------------------Spring Container 초기화 시작---------------------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-1.spring-datasource.xml");
		System.out.println("------------------------Spring Container 초기화 끝---------------------------");
		DataSource appacheDataSource = (DataSource) applicationContext.getBean("apacheDataSource");
		System.out.println("### 1. ApacheDataSource: "+appacheDataSource);
		System.out.println("### 2. ApacheDataSource Connection: "+appacheDataSource.getConnection());
		DataSource springDataSource = (DataSource) applicationContext.getBean("springDataSource");
		System.out.println("### 1. springDataSource: "+springDataSource);
		System.out.println("### 2. springDataSource Connection: "+springDataSource.getConnection());
	}

}
