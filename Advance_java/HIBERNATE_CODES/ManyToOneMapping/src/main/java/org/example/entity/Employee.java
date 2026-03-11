package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    private int empId;

    private String empName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee() {}

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}