package com.restapi.universityapi.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service 
public class StudentService {
	
	@Autowired 
	private StudentRepository studentRepository;

	public List<Student> getstudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> student=new ArrayList<Student>();
		
		studentRepository.findAll().forEach(student::add);
		return student;
	
	}

	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		
		return studentRepository.findById(id).get();
	}

	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		return true;
	}
	public boolean updateStudent(long id,Student student)
	{
		if(studentRepository.findById(id).isPresent()) {
			student.setId(id);
			studentRepository.save(student);
			return true;
		}
		return false;
	}

	public boolean deleteStudent(long id) {
		// TODO Auto-generated method stub
		if(studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
