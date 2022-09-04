package com.example.company.department;

import com.example.company.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getById(Integer id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }


}
