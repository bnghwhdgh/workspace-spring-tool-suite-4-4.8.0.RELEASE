package com.mybatis3.dao;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao = new TutorDao();
		System.out.println("----------findTutorById--------");

		System.out.println("----------selectTutorWithAddressAndCourses--------");
		System.out.println("##### "+tutorDao.findTutorByIdWithCoursesAndAddress(1));
		System.out.println("-------------nestedSelectTutorById----------------");

	}

}
