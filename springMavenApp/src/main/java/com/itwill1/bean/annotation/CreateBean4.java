package com.itwill1.bean.annotation;

import org.springframework.stereotype.Component;

@Component("createBean4")
public class CreateBean4 {
	public CreateBean4() {
		System.out.println("### CreateBean4() 기본생성자");
	}
	public void method1() {
		System.out.println("### CreateBean4().method1() 메소드 호출");
	}
}
