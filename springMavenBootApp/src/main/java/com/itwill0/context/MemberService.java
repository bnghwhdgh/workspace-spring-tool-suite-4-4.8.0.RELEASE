package com.itwill0.context;

import org.springframework.stereotype.Component;

@Component("memberService")
public class MemberService {
	public MemberService() {
		System.out.println("### MemberService() 기본생성자:"+this);
	}

	public void list() {
		System.out.println("### MemberService.list()메쏘드호출");
	}
}
