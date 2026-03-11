package org.example.dao;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

    public void saveEmployee(Employee emp) {

        Configuration cfg = new Configuration()
                .configure()
                .addAnnotatedClass(org.example.entity.Employee.class)
                .addAnnotatedClass(org.example.entity.Department.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(emp);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Employee saved");
    }
}