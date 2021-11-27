package com.simplilearn.service;

import java.util.List;

import com.simplilearn.entity.Student;

public interface StudentService {

	// GET
	List<Student> getAllStudents();

	// GET BY ID
	Student getStudentById(int studentId);

	// POST
	void saveStudent(Student studentObject);

	// PUT
	Student updateStudent(Student studentObject);

	// DELETE
	void deleteStudent(int studentId);
}
