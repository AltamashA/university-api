package com.restapi.myuniversityapi.teachers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.restapi.myuniversityapi.exams.Exam;
import com.restapi.myuniversityapi.topics.Topic;

@Entity 
public class Teacher {
	@Id 
	@GeneratedValue (strategy=GenerationType.AUTO )
	@Column (name="teacher_id")
	private long id;
	
	private String name;
	private String phone;
	private int age;
	
	@OneToOne
	@JoinColumn (name="teacher_id",referencedColumnName="teacher_id")
	private Topic topics;
	
	@OneToMany(cascade=CascadeType.ALL )
	@JoinColumn (name="teacher_id",referencedColumnName="teacher_id")
	private List<Exam > exams;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Topic getTopics() {
		return topics;
	}

	public void setTopics(Topic topics) {
		this.topics = topics;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", topics=" + topics
				+ ", exams=" + exams + "]";
	}

	public Teacher() {
		
	}
	public Teacher(long id, String name, String phone, int age, Topic topics, List<Exam> exams) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.topics = topics;
		this.exams = exams;
	}

	
	

}
