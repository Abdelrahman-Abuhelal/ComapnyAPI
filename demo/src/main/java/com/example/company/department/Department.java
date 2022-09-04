package com.example.company.department;

import com.example.company.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer dep_no;
    private String name;
    @OneToMany(mappedBy = "department")
    List<Employee> employees;

    public Department() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getDep_no() {
        return dep_no;
    }

    public void setDep_no(Integer dep_no) {
        this.dep_no = dep_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
