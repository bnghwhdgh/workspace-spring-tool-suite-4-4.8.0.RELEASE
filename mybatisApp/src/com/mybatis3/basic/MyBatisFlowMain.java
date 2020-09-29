package com.mybatis3.basic;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;


public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 0. mybatis-config.xml => inputStream
		 */
		InputStream mybatisConfigInputStream= Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1. sqlSessionFactoryBuilder객체 생성
		 */
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		/*
		 *2. sqlSessionFactory 객체를 얻어야 함
		 */
		SqlSessionFactory ssf = ssfb.build(mybatisConfigInputStream);
		/*
		 * 3. sqlSession
		 */
		SqlSession sqlSession = ssf.openSession();
		/*
		 * openSession은 괄호안이 비어있다 => autocommit이 true인 상태
		 */
		/*
		 * 4. sqlSession사용(CRUD)
		 */
		System.out.println("####sqlSession 객체: "+sqlSession);
		
		//한 개 뽑기
		Student findStudent = 
				sqlSession.selectOne("com.mybatis3.dao.mapper.StudentMapper.findStudentById",new Integer(1));
		
		System.out.println("####"+findStudent);
		
		//여러개 뽑기
		
		List<Student> studentList =
				sqlSession.selectList("com.mybatis3.dao.mapper.StudentMapper.findAllStudents");
		System.out.println(studentList);
		/*
		 * 5. sqlSession close
		 */
		sqlSession.close();
		
		
	}

}
