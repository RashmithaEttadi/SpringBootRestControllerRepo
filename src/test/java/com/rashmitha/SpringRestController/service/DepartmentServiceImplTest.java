package com.rashmitha.SpringRestController.service;

import com.rashmitha.SpringRestController.entity.Department;
import com.rashmitha.SpringRestController.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceImplTest {
    @Autowired
    private DepartmentServicee departmentServicee;
    @MockBean
    private DepartmentRepo repo;

    @BeforeEach
    void setUp() {

        Department dept= Department.builder()
                .departmentName("IT")
                .deptCode("55")
                .departmentId(1)
                .build();

        Mockito.when(repo.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(dept);


    }
    @Test
    @DisplayName("Department name test case")
    //@Disabled
    public void whenDepartmentNotFound_DeptShouldbeFound()
    {
       String deptName="IT";
       Department dept=departmentServicee.GetDepartmentsByName(deptName);
       assertEquals(deptName, dept.getDepartmentName());
    }
}