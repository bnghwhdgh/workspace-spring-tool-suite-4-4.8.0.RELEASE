package com.itwill.user;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
public class UserDao {
	public static final String NAMESPACE = "com.itwill.user.mapper.UserMapper.";
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDao() throws Exception {
		InputStream mybatisConfigInputStream=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		sqlSessionFactory = ssfb.build(mybatisConfigInputStream);
	}
	 
	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int insertUser(User user)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int updateUser(User user)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateRowCount=sqlSession.update(NAMESPACE+"updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int deleteUser(String userId)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	public User selectById(String userId)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User findUser = sqlSession.selectOne(NAMESPACE+"selectById", userId);
		sqlSession.close();
		return findUser;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public ArrayList<User> selectAll()  {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		List<User> findList = sqlSession.selectList(NAMESPACE+"selectAll");
		sqlSession.close();
		return (ArrayList<User>) findList;
	}

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public boolean existedUser(String userId)  {
		boolean isExist=false;
		int count = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		count = sqlSession.selectOne(NAMESPACE+"selectByIdCount", userId);
		if(count==1) {
			isExist=true;
		}
		sqlSession.close();
		return isExist;
	}

}
