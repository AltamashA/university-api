package com.restapi.myuniversityapi.teachers;

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
public class TeacherController {

		@Autowired 
		private TeacherService teacherservice;
		
		@Autowired 
		private ObjectMapper mapper;
		
		@RequestMapping(value="/teachers/")
		private List <Teacher> getAllTeachers() 
		{
			return teacherservice .getAllTeachers();
			
		}
		
		@RequestMapping (value="/teachers/{id}")
		private Teacher getTeacherById(@PathVariable long id)
		{
			return teacherservice.getTeacherById(id);
		}
		
		@RequestMapping (method=RequestMethod.POST,value="/teachers/")
		private ObjectNode addTeacher(@RequestBody Teacher teacher)
		{
			ObjectNode node=mapper.createObjectNode();
			return node.put("status", teacherservice.addTeacher(teacher));
			
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/teachers/{id}")
		private ObjectNode updateTeacher(@PathVariable long id,@RequestBody Teacher teacher)
		{
			ObjectNode node=mapper.createObjectNode();
			return node.put("status", teacherservice.updateTeacher(id,teacher));
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/teachers/{id}")
		private ObjectNode deleteTeacher(@PathVariable long id)
		{
			ObjectNode node=mapper.createObjectNode();
			return node.put("status",teacherservice.deleteTeacher(id));
		}
}
