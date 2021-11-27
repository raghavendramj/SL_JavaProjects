package com.simplilearn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Student;
import com.simplilearn.repository.StudentRepository;
import com.simplilearn.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student getStudentById(int studentId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);

		if (studentOptional.isPresent()) {
			return studentOptional.get();
		} else {
			return null;
		}
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (studentOptional.isPresent()) {
			studentRepository.delete(studentOptional.get());
		}
	}

	@Override
	public Student updateStudent(Student studentObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
