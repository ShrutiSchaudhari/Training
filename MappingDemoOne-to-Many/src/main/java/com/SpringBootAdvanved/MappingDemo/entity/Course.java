package com.SpringBootAdvanved.MappingDemo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	
	@ManyToOne( cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id" )
	private Instructor instructor;
	

	@ManyToMany( fetch = FetchType.LAZY, 
			cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
		name= "course_student",
				joinColumns= @JoinColumn(name="course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id")
	
	)
	private List<Student> students;
	
	
	
	public Course() {
		
	}

	public Course(String title) {
		
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudents(Student theStudent) {
		
		if(students == null) {
			students = new ArrayList<>();
			
		}
		students.add(theStudent);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
}