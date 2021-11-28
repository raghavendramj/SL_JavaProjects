package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entitiy.Course;
import com.dailycodebuffer.springdatajpatutorial.entitiy.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

/*
    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(6)
                .build();
        Course coursePhyton = Course.builder()
                .courseTitle("Phyton")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Salman")
                .lastName("Khan")
                .courses(Arrays.asList(courseDBA, courseJava, coursePhyton))
                .build();

        teacherRepository.save(teacher);
    }

 */
}