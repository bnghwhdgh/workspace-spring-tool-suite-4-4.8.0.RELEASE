package com.itwill.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.user.mapper.UserMapper;

public class UserMapperInterfaceDaoMyBatis implements UserMapperDao{
	private SqlSessionFactory sqlSessionFactory;
	
	public UserMapperInterfaceDaoMyBatis() {
		try {
			InputStream mybatisConfigInputStream =
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfb.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int insertRowCount = userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public User selectById(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User findUser = userMapper.selectById(userId);
		sqlSession.close();
		return findUser;
	}

	@Override
	public List<User> selectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		ArrayList<User> userList = (ArrayList<User>)userMapper.selectAll();
		sqlSession.close();
		return userList;
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int updateRowCount = userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int deleteRowCount = userMapper.deleteUser(userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}
}
