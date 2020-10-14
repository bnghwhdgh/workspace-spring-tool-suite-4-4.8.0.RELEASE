package com.itwill.guest;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class GuestDaoImpl implements GuestDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.itwill.guest.mapper.GuestMapper.";
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public GuestDaoImpl() throws Exception {
		
	}
	

//	public void setDataSource(DataSource dataSource) {
//		System.out.println("### GuestDaoImpl : setDataSource("+dataSource+") 메쏘드호출 ");
//		this.dataSource = dataSource;
//	}


	@Override
	public int insertGuest(Guest guest) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest = null;
		sqlSession=sqlSessionFactory.openSession();
		guest=sqlSession.selectOne(NAMESPACE+"selectByNo", no);
		sqlSession.close();
		return guest;
	}

	/*
	 * 이름 널? 유형 -------------- -------- -------------- GUEST_NO NOT NULL NUMBER(10)
	 * GUEST_NAME NOT NULL VARCHAR2(100) GUEST_DATE NOT NULL DATE GUEST_EMAIL
	 * VARCHAR2(100) GUEST_HOMEPAGE VARCHAR2(100) GUEST_TITLE NOT NULL VARCHAR2(255)
	 * GUEST_CONTENT NOT NULL VARCHAR2(4000)
	 */
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		List<Guest>guestList = sqlSession.selectList(NAMESPACE+"selectAll");
		sqlSession.close();
		return (ArrayList<Guest>)guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.update(NAMESPACE+"updateGuest", guest);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteGuest", no);
		return deleteRowCount;
	}
}
