package org.app;

import org.dao.DepartmentDAO;
import org.entity.Department;
import org.entity.Employee;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");

        Employee e1 = new Employee();
        e1.setEmpId(101);
        e1.setEmpName("Rahul");
        e1.setDepartment(dept);

        Employee e2 = new Employee();
        e2.setEmpId(102);
        e2.setEmpName("Aman");
        e2.setDepartment(dept);

        dept.setEmployees(Arrays.asList(e1, e2));

        DepartmentDAO dao = new DepartmentDAO();
        dao.saveDepartment(dept);

    }
}