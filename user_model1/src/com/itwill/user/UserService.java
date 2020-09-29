package com.itwill.user;
/*
 * - 회원관리 비즈니스로직(예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴퍼넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - Dao를 이용해서 데이타베이스를 조작작업하는 클래스
 */

import java.util.ArrayList;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserService {
	private UserDao userDao;
	
	public UserService() throws Exception{
		//dao객체에 datasource가 있다!
		userDao=new UserDao();
	}
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception,ExistedUserException/*사용자정의 예외처리=>Exception을 상속받는다*/{
		
		/*
		 * 1. 아이디 중복체크
		 */
		if(userDao.existedUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId()+"는 이미 존재하는 아이디입니다.");
		}
		return userDao.create(user);
	}
	/*
	 * 회원리스트
	 */
	public ArrayList<User> findUserList() throws Exception{
		ArrayList<User> userList= userDao.findUserList();
		return userList;
	}
	/*
	 * 아이디중복체크
	 * 
	 */
	
	/*
	 * 회원 로그인
	 */
	public User login(String userId,String password) throws Exception{
		/*
		 * 1. 아이디 존재여부 확인
		 */
		User user = userDao.findUser(userId);
		if(user==null) {
			//throw new UserNotFoundException(message); 
			//=> login_action의 catch(UserNotFoundException e)에서 e.getMessage로 읽어 오는 놈
			throw new UserNotFoundException(userId+"는 존재하지 않는 아이디입니다.");
		}
		/*
		 * 2. 패스워드 일치여부 확인
		 */
		if(!user.isMatchPassword(password)) {
			throw new PasswordMismatchException("패스워드가 일치하지 않습니다.");
		}
		return user;
	}
	/*
	 * 회원1명보기
	 */
	public User findUser(String userId) throws Exception,UserNotFoundException{
		
		User finduser= userDao.findUser(userId);
		if( finduser == null) {
			throw new UserNotFoundException("존재하지 않는 회원입니다.");
		}
		return finduser;
	}
	/*
	 * 회원탈퇴
	 */
	public int removeUser(String userId) throws Exception {
		int removeUser = userDao.remove(userId);
		return removeUser;
	}
	/*
	 * 회원수정
	 */
	public int updateUser(User user) throws Exception{
		int updateUser = userDao.update(user);
		return updateUser;
	}
}




