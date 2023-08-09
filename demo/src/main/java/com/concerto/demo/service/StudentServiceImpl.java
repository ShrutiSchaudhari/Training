package com.concerto.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.demo.entity.Student;
import com.concerto.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	//repo object
	@Autowired
	private StudentRepository studentRepository;
	
	
	//constructor
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(int id) {

		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {

		return studentRepository.save(student) ;
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
	}

}
