package com.rashmitha.SpringRestController.controller;

import com.rashmitha.SpringRestController.entity.Department;
import com.rashmitha.SpringRestController.error.DepartmentNotFound;
import com.rashmitha.SpringRestController.service.DepartmentServiceImpl;
import com.rashmitha.SpringRestController.service.DepartmentServicee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class frontController {

    @Autowired
    private DepartmentServicee departmentservice;
    private final Logger logger= LoggerFactory.getLogger(Department.class);
    @PostMapping("/departments")
    public Department AddDepartment(@RequestBody Department dept)
    {
        logger.info("Inside Add department method");
        return departmentservice.AddDepartment(dept);
    }

    @GetMapping("/departments")
    public List<Department> GetDepartments()
    {
        return departmentservice.GetDepartments();
    }

    @GetMapping("/departments/{dept_id}")
    public Department GetDepartments(@PathVariable("dept_id") int deptid)
            throws DepartmentNotFound {
        return departmentservice.GetDepartments(deptid);
    }
    @DeleteMapping("/departments/{dept_id}")
    public String DeleteDepartment(@PathVariable("dept_id") int deptid){
        return departmentservice.DeleteDepartment(deptid);
    }

    @PutMapping("/departments/{dept_id}")
    public Department UpdateDepartments(@PathVariable("dept_id")int deptid,@RequestBody Department dept)
    {
        return departmentservice.UpdateDepartments(deptid,dept);
    }

    @GetMapping("/departments/name/{dept_name}")
    public Department GetDepartmentsByName(@PathVariable("dept_name") String deptname)
    {
        return departmentservice.GetDepartmentsByName(deptname);
    }
}
