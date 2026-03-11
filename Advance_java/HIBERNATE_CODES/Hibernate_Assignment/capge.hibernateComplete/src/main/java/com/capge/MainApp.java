package com.capge;

import com.capge.entity.Student;
import com.capge.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Get SessionFactory
        SessionFactory sessionFactory = StudentRepository.getSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 🔹 Create Student
        Student student = new Student();
        student.setName("Parth");
        student.setDept("IT");
        student.setAge(22);
        student.setMarks(88.5);

        // 🔹 Save
        session.persist(student);

        transaction.commit();
        session.close();

        // 🔹 Fetch All Students
        Session newSession = sessionFactory.openSession();
        List<Student> list =
                newSession.createQuery("from Student", Student.class)
                        .getResultList();

        System.out.println("All Students:");
        list.forEach(System.out::println);

        newSession.close();

        // Close SessionFactory (very important)
        sessionFactory.close();
    }
}
