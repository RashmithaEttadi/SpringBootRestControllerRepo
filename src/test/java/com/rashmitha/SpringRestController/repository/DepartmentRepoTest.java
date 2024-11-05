package com.rashmitha.SpringRestController.repository;

import com.rashmitha.SpringRestController.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepoTest {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {

        Department department= Department.builder()
                .departmentName("Engineering")
                .deptCode("55")
                .build();
        entityManager.persist(department);
    }

    @Test
    void whenFindById_test() {
       Department department1=departmentRepo.findAll().get(0);

        assertEquals(department1.getDepartmentName(),"Engineering");
    }
}