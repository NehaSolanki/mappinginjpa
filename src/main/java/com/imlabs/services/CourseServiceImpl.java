package com.imlabs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlabs.model.*;

import com.imlabs.repositories.*;



@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	
	
	
	@Autowired
	CourseRepositoryMysqlPublisher courseRepositoryMysqlPublisher;
	

	
	
	

	@Override
	public void insertCourse(CourseMysql course) {
		courseRepositoryMysqlPublisher.save(course);
		
	}

	@Override
	public List<CourseMysql> findAllCourses() {
		return courseRepositoryMysqlPublisher.findAll();
	}

	@Override
	public void deleteCourse(long id) {
		courseRepositoryMysqlPublisher.delete(id);
	
	}

	@Override
	public void updateCourse(CourseMysql course) {
		
		courseRepositoryMysqlPublisher.save(course);
		
	}

	@Override
	public CourseMysql getCourseById(long id) {
		return courseRepositoryMysqlPublisher.findOne(id);
	}

	@Override
	public List<CourseMysql> findCoursesForArea(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
