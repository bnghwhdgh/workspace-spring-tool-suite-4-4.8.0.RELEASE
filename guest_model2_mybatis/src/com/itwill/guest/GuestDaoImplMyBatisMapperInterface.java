package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisMapperInterface implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public GuestDaoImplMyBatisMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertRow = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.commit();
		sqlSession.close();
		return insertRow;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.commit();
		sqlSession.close();
		return  sqlSessionFactory.openSession().getMapper(GuestMapper.class).selectByNo(no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		
		sqlSession.commit();
		sqlSession.close();
		return null;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.commit();
		sqlSession.close();
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return 0;
	}

}
