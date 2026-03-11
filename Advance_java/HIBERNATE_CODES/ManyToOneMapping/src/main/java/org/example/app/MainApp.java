package org.example.app;

import org.example.dao.EmployeeDAO;
import org.example.entity.Department;
import org.example.entity.Employee;

public class MainApp {

    public static void main(String[] args) {

        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");

        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setEmpName("Rahul");
        emp.setDepartment(dept);

        EmployeeDAO dao = new EmployeeDAO();
        dao.saveEmployee(emp);
    }
}