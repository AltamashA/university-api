package com.restapi.universityapi.students;

import java.util.Date;
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

import com.restapi.universityapi.courses.Course;
import com.restapi.universityapi.exams.Exam;

@Entity 
public class Student {
	
	@Id 
	@Column (name="student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public Student(long id, String name, Date dob, String sex, String year, Course course, List<Exam> exam) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.year = year;
		this.course = course;
		this.exam = exam;
	}
	public Student()
	{
	
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", sex=" + sex + ", year=" + year + ", course="
				+ course + ", exam=" + exam + "]";
	}
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Exam> getExam() {
		return exam;
	}
	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}

	private String name;
	private Date dob;
	private String sex;
	private String year;
	
	@OneToOne
	@JoinColumn(name="student_id" ,referencedColumnName="student_id")
	private Course course;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn (name="student_id",referencedColumnName="student_id")
	private List<Exam> exam;
	

}
