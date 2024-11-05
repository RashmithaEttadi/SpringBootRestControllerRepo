package com.rashmitha.SpringRestController.service;

import com.rashmitha.SpringRestController.entity.Department;
import com.rashmitha.SpringRestController.error.DepartmentNotFound;
import com.rashmitha.SpringRestController.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentServicee{

    @Autowired
    private DepartmentRepo repo;
    @Override
    public Department AddDepartment(Department dept) {

        return repo.save(dept);
    }

    @Override
    public List<Department> GetDepartments() {
        return repo.findAll();
    }

    @Override
    public Department GetDepartments(int deptid) throws DepartmentNotFound {
        Optional<Department> department= repo.findById(deptid);

        if(department.isEmpty())
        {
           throw new DepartmentNotFound("Department not available");
        }
        return department.get();
    }

    @Override
    public String DeleteDepartment(int deptid) {
        repo.deleteById(deptid);
        return "deleted";
    }

    @Override
    public Department UpdateDepartments(int deptid, Department dept) {
        Department d=repo.findById(deptid).get();
       if(Objects.nonNull(dept.getDepartmentName())&&
               !"".equalsIgnoreCase(dept.getDepartmentName())) {
           d.setDepartmentName(dept.getDepartmentName());
       }
        if(Objects.nonNull(dept.getDeptCode())&&
                !"".equalsIgnoreCase(dept.getDeptCode())) {
            d.setDeptCode(dept.getDeptCode());
        }
        return repo.save(d);
    }

    @Override
    public Department GetDepartmentsByName(String deptname) {

        return repo.findByDepartmentNameIgnoreCase(deptname);
    }

//    @Override
//    public Department UpdateDepartments(Department dept) {
//        return repo.
//    }


}
