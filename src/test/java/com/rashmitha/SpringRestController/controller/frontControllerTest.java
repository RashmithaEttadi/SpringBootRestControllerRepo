package com.rashmitha.SpringRestController.controller;

import com.rashmitha.SpringRestController.entity.Department;
import com.rashmitha.SpringRestController.service.DepartmentServicee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//import static org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(frontController.class)
class frontControllerTest {
    @Autowired
    private MockMvc mockmvc;
    @MockBean
    private DepartmentServicee departmentServicee;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .deptCode("06")
                .departmentId(1)
                .build();


    }

    @Test
    void addDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("IT")
                .deptCode("06")
                .build();
        Mockito.when(departmentServicee.AddDepartment(inputdepartment))
                .thenReturn(department);

        mockmvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\":\"IT\",\n" +
                                "    \"deptCode\":\"06\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}

//    @Test
//    void getDepartmentsByName() throws Exception {
//
//        Mockito.when(departmentServicee.GetDepartmentsByName("IT"))
//                .thenReturn(department);
//
//        mockmvc.perform(MockMvcRequestBuilders.get("/departments/name/IT")
//                .contentType(MediaType.APPLICATION_JSON)
//                .andExpect( jsonPath("$.departmentName")
//                        .value(department.getDepartmentName())));
//    }
