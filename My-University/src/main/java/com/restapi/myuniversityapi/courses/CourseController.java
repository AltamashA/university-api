package com.restapi.myuniversityapi.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restapi.myuniversityapi.topics.Topic;


@RestController 
public class CourseController {
	
	/*@Autowired
	private CourseService courseservice;
	
	private ObjectMapper mapper;

	@RequestMapping(method=RequestMethod.GET,value="/courses/")
	private List<Course> getAllCourse()
	{
		return courseservice.getAllCourses();
	}	
	
	@RequestMapping(method=RequestMethod.GET,value="/courses/{id}")
	
	private Course getCourseById(@PathVariable long id)
	{
		return courseservice.getCourseById(id);
	}
	@RequestMapping(method=RequestMethod.GET,value="/topic/{topic_id}/courses/")
	private List<Course>getAllCoursesByTopic(@PathVariable long topic_id)
	{
		return courseservice.getCoursesByTopic(topic_id);			
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public ObjectNode addCourse(@RequestBody Course course,@PathVariable long topicId)
	{
		ObjectNode node= mapper.createObjectNode();
		course.setTopic(new Topic(topicId,""));
		return node.put("status", courseservice.addCourse(course));
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	private ObjectNode updateCourse(@RequestBody Course course,@PathVariable long id,@PathVariable long topicId)
	{
		ObjectNode node=mapper.createObjectNode();
		course.setTopic(new Topic (topicId," "));
		return node.put("status", courseservice.updateCourse(course,id));
	}
	
	@RequestMapping(method=RequestMethod.DELETE ,value="/courses/{id}")
	private ObjectNode deleteCourse(@PathVariable long id)
	{
		ObjectNode node=mapper.createObjectNode();
		return node.put("status", courseservice.deletecourse(id));
	}
	
}
