package com.example.company.employee;


import com.example.company.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesOnDept(Integer id){
        return departmentRepository.getById(id).getEmployees();
    }

    public Optional<Employee> getById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

}
