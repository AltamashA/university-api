package com.restapi.universityapi.teachers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service 
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository; 
	
	public List<Teacher> getAllTeachers() {
		ArrayList<Teacher> teacher=new ArrayList<Teacher>();
		teacherRepository.findAll().forEach(teacher::add );
		return teacher;
	}

	public Teacher getTeacherById(long id) {
		
		return teacherRepository.findById(id).get();
	}

	public boolean addTeacher(Teacher teacher) {
		 teacherRepository.save(teacher);
		 return true;	
	
	}

	public boolean updateTeacher(long id, Teacher newteacher ) {
		if(teacherRepository.findById(id).isPresent())
			{
			teacherRepository.save(newteacher);
			return true;
			}
		
		return false;
	}

	public boolean deleteTeacher(long id) {
		
		if(teacherRepository.findById(id).isPresent() )
		{
			teacherRepository.deleteById( id);
			return true;
			
		}
		return false;
	}
	

}
