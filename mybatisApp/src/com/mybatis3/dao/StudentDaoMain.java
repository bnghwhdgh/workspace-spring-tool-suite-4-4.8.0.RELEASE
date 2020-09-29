package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(1));
		System.out.println("---------findAllStudents---------");
		System.out.println("###"+studentDao.findAllStudents());
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("###"+studentDao.findStudentByIdResultMap(3));
		System.out.println("---------insertStudent(Dto)--------------");
		//Student student1=new Student(8000, "김팔천", "eight@gmail.com", new Date());
		//System.out.println("###"+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1---------");
		Student student2=
				new Student(null, "김시퀀스1", "seq1@gmail.com", new Date());
		System.out.println("###"+studentDao.insertStudentBySequence1(student2));
		System.out.println("insert PK -->"+student2.getStudId());
		System.out.println("---------insertStudentBySequence2---------");
		Student student3=
				new Student(null, "김시퀀스2", "seq2@gmail.com", new Date());
		System.out.println("###"+studentDao.insertStudentBySequence2(student3));
		System.out.println("insert PK -->"+student3.getStudId());
		System.out.println("---------updateStudent-------------------");
		Student updateStudent = studentDao.findStudentById(1);
		//updateStudent.setName("변경2");
		//updateStudent.setEmail("change2@gmail.com");
		updateStudent.setDob(new Date());
		System.out.println("###"+studentDao.updateStudent(updateStudent));
		System.out.println("---------deleteStudentById------------------");
		System.out.println("###"+studentDao.deleteStudentById(10));
		System.out.println("###"+studentDao.deleteStudentByName("김팔천"));
		System.out.println("###"+studentDao.deleteStudentByNameLike("김시퀀스"));
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("###"+studentDao.findStudentByIdWithAddress(3));
		System.out.println("---------findStudentByIdWithCourses----------");
		System.out.println("###"+studentDao.findStudentByIdWithCourses(1));
		
		System.out.println("---------findStudentNameList----------");
		System.out.println(studentDao.findStudentNameList());
		
		System.out.println("---------findStudentNameById----------");
		System.out.println(studentDao.findStudentNameById(1));
		
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("####맵:"+studentDao.findStudentByIdMap(1));
		System.out.println("###그냥아이디"+studentDao.findStudentById(1));
		System.out.println("------------findAllStudentsListMap-------------");
		System.out.println("####:"+studentDao.findAllStudentMapList());
		
		
		System.out.println("----------updateStudentParamMap-----------");
		HashMap studentMap = new HashMap();
		studentMap.put("studId", 1);
		studentMap.put("name", "유노유노");
		studentMap.put("email", "you@no.co.kr");
		studentMap.put("dob", new Date());
		System.out.println("###"+studentDao.updateStudentParamMap(studentMap));
		
		System.out.println("----------findStudentByIdParamMap(parameter Map)-----------");
		HashMap rangeMap = new HashMap();
		rangeMap.put("startNo", 1);
		rangeMap.put("endNo", 3);
		System.out.println("###"+studentDao.findStudentByIdRangeParamMap(rangeMap));
		
		System.out.println("----------findStudentsThreeParamMap(parameter Map)-----------");
		Student firstStudent=new Student(1);
		Student secondStudent=new Student(3);
		Student thirdStudent=new Student(5);
		HashMap threeStudentMap = new HashMap();
		threeStudentMap.put("first", firstStudent);
		threeStudentMap.put("second", secondStudent);
		threeStudentMap.put("third", thirdStudent);
		System.out.println("###"+studentDao.findStudentThreeParamMap(threeStudentMap));
		
		/*
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------insertStudentParameterMap(parameter Map)----");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/
	}
}
