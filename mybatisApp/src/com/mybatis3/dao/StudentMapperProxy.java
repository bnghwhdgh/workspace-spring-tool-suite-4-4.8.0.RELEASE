package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class StudentMapperProxy implements StudentMapper{
	private SqlSession sqlSession;
	@Override
	public Student findStudentById(Integer studId) {
		String namespace =StudentMapper.class.getName();
		System.out.println(StudentMapper.class);
		System.out.println("--------");
		System.out.println(namespace);
		Student findStudent=
				sqlSession
				.selectOne(namespace+"findStudentById",
						studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	@Override
	public List<Student> findAllStudents() {
		String namespace =StudentMapper.class.getName();
		List<Student> studentList = sqlSession.selectList(namespace+"findAllStudents");
		sqlSession.commit();
		sqlSession.close();
		return studentList;
	}
	@Override
	public int insertStudentBySequence2(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
