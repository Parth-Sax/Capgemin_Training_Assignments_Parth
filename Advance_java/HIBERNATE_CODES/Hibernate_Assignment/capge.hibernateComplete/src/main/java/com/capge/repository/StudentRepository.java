package com.capge.repository;

import com.capge.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentRepository {
    private static SessionFactory sessionFactory;


    static {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
