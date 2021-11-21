package com.raghav.springboot.tutorial.service;

import com.raghav.springboot.tutorial.entity.Department;
import com.raghav.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
