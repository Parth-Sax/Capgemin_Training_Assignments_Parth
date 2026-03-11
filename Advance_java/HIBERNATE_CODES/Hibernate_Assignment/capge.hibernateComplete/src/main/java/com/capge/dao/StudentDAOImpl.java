package com.capge.dao;

import com.capge.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    private final SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    @Override
    public List<Student> fetchAll() {
        Session session = sessionFactory.openSession();

        List<Student> list =
                session.createQuery("from Student", Student.class)
                        .getResultList();

        session.close();
        return list;
    }

    @Override
    public Student fetchById(int id) {
        Session session = sessionFactory.openSession();

        Student student = session.createQuery("from student where id=:id", Student.class)
                        .setParameter("id", id)
                        .uniqueResult();

        session.close();
        return student;
    }

    @Override
    public void updateMarks(int id, double marks) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.createQuery(
                        "update Student set marks = :marks where id = :id")
                .setParameter("marks", marks)
                .setParameter("id", id)
                .executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }

    @Override
    public List<Student> sortedByMarks() {
        Session session = sessionFactory.openSession();

        List<Student> list =
                session.createQuery(
                                "from Student order by marks asc",
                                Student.class)
                        .getResultList();

        session.close();
        return list;
    }

    @Override
    public List<Student> sortedByAgeDesc() {
        Session session = sessionFactory.openSession();

        List<Student> list =
                session.createQuery(
                                "from Student order by age desc",
                                Student.class)
                        .getResultList();

        session.close();
        return list;
    }

    @Override
    public List<Student> filterByDept(String dept) {
        Session session = sessionFactory.openSession();

        List<Student> list =
                session.createQuery(
                                "from Student where dept = :dept",
                                Student.class)
                        .setParameter("dept", dept)
                        .getResultList();

        session.close();
        return list;
    }

    @Override
    public List<Student> nativeFetch() {
        Session session = sessionFactory.openSession();

        List<Student> list =
                session.createNativeQuery(
                                "SELECT * FROM student",
                                Student.class)
                        .getResultList();

        session.close();
        return list;
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.createNativeQuery(
                        "UPDATE student SET marks = :marks WHERE id = :id")
                .setParameter("marks", marks)
                .setParameter("id", id)
                .executeUpdate();

        tx.commit();
        session.close();
    }
}

