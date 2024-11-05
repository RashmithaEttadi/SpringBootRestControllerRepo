package com.rashmitha.SpringRestController.repository;

import com.rashmitha.SpringRestController.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
  public Department findByDepartmentName(String deptname);
    public Department findByDepartmentNameIgnoreCase(String deptname);
}
