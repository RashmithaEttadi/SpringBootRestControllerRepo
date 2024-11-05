package com.rashmitha.SpringRestController.service;

import com.rashmitha.SpringRestController.entity.Department;
import com.rashmitha.SpringRestController.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentServicee {
    public Department AddDepartment(Department dept);
    public List<Department> GetDepartments();

    public Department GetDepartments(int deptid) throws DepartmentNotFound;
    public String DeleteDepartment(int deptid);

    //public Department UpdateDepartments(Department dept);

    public Department UpdateDepartments(int deptid, Department dept);

    public Department GetDepartmentsByName(String deptname);
}
