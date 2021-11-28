//package com.dailycodebuffer.springdatajpatutorial.repository;
//
//import com.dailycodebuffer.springdatajpatutorial.entitiy.Course;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface CourseRepository extends JpaRepository<Course, Long> {
//    Page<Course> findByCourseTitleContaining(String title, Pageable pageRequest);
//}
