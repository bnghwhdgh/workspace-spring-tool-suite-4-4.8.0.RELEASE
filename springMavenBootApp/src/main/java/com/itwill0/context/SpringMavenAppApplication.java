package com.itwill0.context;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMavenAppApplication {

	public static void main(String[] args) {
		/********************************Spring이 제어한다 => IoC*************************************/
		System.out.println("-----------------------Spring Container 시작--------------------------");
		ApplicationContext applicationContext= SpringApplication.run(SpringMavenAppApplication.class, args);
		System.out.println("ApplicationContext[BeanFactory,SpringContainer객체]: "+applicationContext);
		System.out.println("--------------------Spring Container 끝-----------------------------");
		/********************************************************************************************/
		//getBean(@Component("이름"))
		System.out.println(applicationContext);
		ProductService productService =  (ProductService)applicationContext.getBean("productService");
		productService.list();
		
		
		/* 개발자가 제어하는 경우
		ProductDao productDao = new ProductDao();
		ProductService productService = new ProductService();
		productService.setProductDao(productDao);
		productService.list();
		*/
	}

}
