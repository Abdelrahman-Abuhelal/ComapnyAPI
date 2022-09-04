package com.example.company.employee;

import com.example.company.department.Department;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer emp_no;
    private String emp_name;
    private String emp_email;
    private String address;
    private Date birthDate;
    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(int emp_no, String emp_name, String emp_email, String address, Date birthDate, Department department) {
        this.emp_no = emp_no;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.address = address;
        this.birthDate = birthDate;
        this.department = department;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
