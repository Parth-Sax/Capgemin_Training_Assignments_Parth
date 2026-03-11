package org.dao;

import org.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentDAO {

    public void saveDepartment(Department dept) {

        Configuration cfg = new Configuration()
                .configure()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(org.entity.Employee.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(dept);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Data saved successfully");
    }
}