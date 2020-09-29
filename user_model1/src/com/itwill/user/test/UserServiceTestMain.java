package com.itwill.user.test;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserServiceTestMain {

	public static void main(String[] args) throws Exception {
		UserService userService = new UserService();
		// 삭제 확인: System.out.println("삭제됐냐?: "+userService.removeUser("guard5"));
		User user = userService.findUser("abcd");
		user.setName("이말년");
		System.out.println("업뎃 하실?: "+userService.updateUser(user));
	}

}
