package com.example.company.department;

import com.example.company.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;



    @Autowired
    public DepartmentController(DepartmentService departmentService,EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService=employeeService;
    }

    @PostMapping(value = "/departments")
    public void adding(@RequestParam Department department){
        departmentService.addDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> departments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{dep_id}")
    public Optional<Department> getDept(@PathVariable Integer dep_id){
        return departmentService.getById(dep_id);
    }
//    @GetMapping("/employees/department/{dep_id}")
//    public  Department getEmployeeByDept(@PathVariable Integer e_id,Integer dep_id){
//      return employeeService.getAllEmployees().get(departmentService.getById(dep_id))
//   }


    @RequestMapping(method = RequestMethod.DELETE,value = "/department/{dep_id}")
    public void deleteDept(@PathVariable Integer dep_id){
        departmentService.deleteDepartment(dep_id);
    }


}
