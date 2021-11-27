package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Student;
import com.simplilearn.service.StudentService;

@RestController
@RequestMapping("/studentResource")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable("id") int studentId) {
		return studentService.getStudentById(studentId);
	}

	@PostMapping("/students")
	public void saveStudent(@RequestBody Student newStudent) {
		studentService.saveStudent(newStudent);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudentById(@PathVariable("id") int studentId) {
		studentService.deleteStudent(studentId);
	}
}
