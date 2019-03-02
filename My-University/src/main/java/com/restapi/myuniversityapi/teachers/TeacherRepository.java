package com.restapi.myuniversityapi.teachers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TeacherRepository extends CrudRepository <Teacher,Long> {
	

}
