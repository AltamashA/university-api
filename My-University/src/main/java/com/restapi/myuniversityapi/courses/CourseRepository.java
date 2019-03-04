package com.restapi.myuniversityapi.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CourseRepository extends CrudRepository<Course, Long> {

		public List<Course> findByTopicId(Long topicId);
}
