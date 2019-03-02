package com.restapi.myuniversityapi.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController 
public class StudentController {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired 
	private StudentService studentService;
	
	@RequestMapping (value="/student/")
	private List<Student> getStudents()
	{
		return studentService.getstudents();
	}
	
	@RequestMapping (value="/student/{id}")
	private Student getStudentById(@PathVariable long id)
	{
		return studentService.getStudentById(id);
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/student/")
	private ObjectNode addStudent(@RequestBody Student student)
	{
		ObjectNode node=mapper.createObjectNode();
			return node.put("status",studentService.addStudent(student));
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/student/{id}")
	private ObjectNode updateStudent(@PathVariable long id, @RequestBody Student student)
	{
		ObjectNode node = mapper.createObjectNode();
		return node.put("status", studentService.updateStudent(id,student));
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/student/{id}")
	private ObjectNode deleteStudent(@PathVariable long id) {
		ObjectNode node = mapper.createObjectNode();
		return node.put("status", studentService.deleteStudent(id));
	}

}
