package com.example.company.employee;

import com.example.company.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService=departmentService;
    }

    @PostMapping(value = "/employees")
    public Employee addEmp(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping("/department/{id}/employees")
    public  List<Employee>  getEmployeeByDept(@PathVariable("id") Integer id){
        return employeeService.getEmployeesOnDept(id);
    }

//    @GetMapping("/department/{id}/employee/{e_id}")
//    public  List<Employee>  getEmployeeByDept(@PathVariable Integer id,Integer e_id){
//        return departmentService.getById(id).get().
//    }


    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    public List<Employee> employees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getDept(@PathVariable Integer id){
        return employeeService.getById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/employees/{id}")
    public void deleteDept(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
}
