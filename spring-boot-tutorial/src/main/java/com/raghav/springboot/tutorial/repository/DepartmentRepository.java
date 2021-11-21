package com.raghav.springboot.tutorial.repository;

import com.raghav.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentName);
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
