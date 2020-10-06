package com.itwill3.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
		
		int insertRowCount = userMapper.insertUser(user);
		return insertRowCount;
	}

	@Override
	public int update(User user) throws Exception {
		int updateRowCount = userMapper.updateUser(user);
		return updateRowCount;
	}

	@Override
	public int remove(String userId) throws Exception {
		int deleteRowCount = userMapper.deleteUser(userId);
		return deleteRowCount;
	}

	@Override
	public User findUser(String userId) throws Exception {
		User findUser = userMapper.selectById(userId);
		
		return findUser;
	}

	@Override
	public List<User> findUserList() throws Exception {
		ArrayList<User> userList = (ArrayList<User>)userMapper.selectAll();
		return userList;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
