package com.raghav.springboot.tutorial.controller;

import com.raghav.springboot.tutorial.entity.Department;
import com.raghav.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    Department department;
    @Autowired
    private DepartmentController departmentController;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("IT-012")
                .departmentId(2L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("IT-012")
                .build();
        when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{  \"departmentName\" : \"IT\", \"departmentAddress\":\"Bangalore\", \"departmentCode\":\"IT-012\" }"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        when(departmentService.fetchDepartmentById(2L)).thenReturn(department);
        mockMvc.perform(get("/departments/2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}