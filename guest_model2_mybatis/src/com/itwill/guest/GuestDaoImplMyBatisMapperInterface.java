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
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int insertRowCount =guestMapper.insertGuest(guest);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		Guest findGuest = guestMapper.selectByNo(no);
		sqlSession.close();
		return  findGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		ArrayList<Guest> guestList = (ArrayList<Guest>)guestMapper.selectAll();
		sqlSession.close();
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int updateRowCount = guestMapper.updateGuest(guest);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int deleteRowCount = guestMapper.deleteGuest(no);
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}

}
