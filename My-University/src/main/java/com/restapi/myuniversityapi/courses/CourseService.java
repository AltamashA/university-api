package com.restapi.myuniversityapi.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CourseService {
	
	@Autowired
	private CourseRepository courserepo;

	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList <Course>();
		courserepo.findAll().forEach(courses::add);
		return courses;
	}

	public List<Course> getCoursesByTopic(long topic_id) {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		courserepo.findByTopicId(topic_id).forEach(courses::add);
		return courses;
	}

	public boolean addCourse(Course course) {		
		courserepo.save(course);
		return true;
	}

	public Course getCourseById(long id) {
		
		return courserepo.findById(id).get();
	}

	public boolean updateCourse(Course course, long id) {
		if(courserepo.findById(id).isPresent()) {
			course.setId(id);
			courserepo.save(course);
			return true;
		}
		return false;
	}

	public boolean deletecourse(long id) {
		if(courserepo.findById(id).isPresent())
		{
			courserepo.deleteById( id);
			return true;
		}
		return false;
	}


}
