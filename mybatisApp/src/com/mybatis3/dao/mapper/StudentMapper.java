package com.mybatis3.dao.mapper;

import java.util.List;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/* 
	 * 인터페이스의 풀네임 (com.mybatis3.dao.mapper)은 StudentMapper.xml의 namespace와 일치시킨다.
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치
	 */
	public Student findStudentById(Integer id);
	/*
	<select id="findStudentById" 
			parameterType="java.lang.Integer"
			resultType="com.mybatis3.domain.Student">
		select stud_id as studid ,name,email,dob 
		from students
		where stud_id = #{studId}
	</select>
	*/
	public List<Student> findAllStudents();
	
	/*
	 *  <select id="findAllStudents" 
			resultType="com.mybatis3.domain.Student">
			select stud_id as studid ,name,email,dob
			from students
		</select>
	 */
	
	/*
	 * <insert id="insertStudentBySequence2" 
			parameterType="com.mybatis3.domain.Student">
		<selectKey order="BEFORE" keyProperty="studId" resultType="int">
			select STUDENTS_STUD_ID_SEQ.nextval from dual
		</selectKey>
		insert into students(stud_id,name,email,dob)
		values (#{studId},#{name},#{email},#{dob})	
	</insert>
	 */
	public int insertStudentBySequence2(Student student);
}
