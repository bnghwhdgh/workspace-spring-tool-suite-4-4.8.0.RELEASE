package com.itwill3.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill3.dao.user.mapper.UserMapper;

public class UserDaoImplMybatisMapperInterface implements UserDao{
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDaoImplMybatisMapperInterface() throws Exception{
		
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
