package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entitiy.Course;
import com.dailycodebuffer.springdatajpatutorial.entitiy.Student;
import com.dailycodebuffer.springdatajpatutorial.entitiy.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("List of courses : " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Stella")
                .lastName("Marry")
                .build();

        Course courseDBA = Course.builder()
                .courseTitle("Javascript")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(courseDBA);
    }


    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

        List<Course> availCourses = courseRepository.findAll(secondPageWithThreeRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements -> " + totalElements);
        System.out.println("totalPages -> " + totalPages);
        System.out.println("availCourses -> " + availCourses);

    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
        Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("courseTitle").descending().and(Sort.by("credit").descending()));

        List<Course> availCourses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("sorted availCourses -> " + availCourses);
    }


    @Test
    public void printFindByTitleByContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> availCourses = courseRepository.findByCourseTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println("availCourses -> " + availCourses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Girish")
                .lastName("Mysore")
                .build();

        Student student = Student.builder()
                .firstName("Lohith")
                .lastName("S R")
                .emailId("lohith@gmail.com")
                .build();


        Course course = Course.builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .students(Arrays.asList(student))
                .build();

        courseRepository.save(course);
    }
}