package com.raghav.springboot.tutorial.service;

import com.raghav.springboot.tutorial.entity.Department;
import com.raghav.springboot.tutorial.error.DepartmentNotFoundException;
import com.raghav.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException(("Department Not Available!"));
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        if(departmentRepository.findById(departmentId).isPresent()){
            Department depFromDB = departmentRepository.findById(departmentId).get();

            if(Objects.nonNull(depFromDB.getDepartmentName()) && !"".equalsIgnoreCase(depFromDB.getDepartmentName())){
                depFromDB.setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(depFromDB.getDepartmentAddress()) && !"".equalsIgnoreCase(depFromDB.getDepartmentAddress())){
                depFromDB.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(Objects.nonNull(depFromDB.getDepartmentCode()) && !"".equalsIgnoreCase(depFromDB.getDepartmentCode())){
                depFromDB.setDepartmentCode(department.getDepartmentCode());
            }
            return departmentRepository.save(depFromDB);
        }
        return null;
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
