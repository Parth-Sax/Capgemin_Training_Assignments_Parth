package org.capge.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-example");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Get Transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // -------- SAVE --------
        Person p1 = new Person();
        p1.setId(7812);
        p1.setName("FIN");
        p1.setSalary(1.2);

        em.persist(p1);

        tx.commit();

        // -------- FETCH BY ID --------
        Person foundPerson = em.find(Person.class, 7812);
        System.out.println("Fetched By ID: " + foundPerson);

        // -------- FETCH ALL --------
        List<Person> list =
                em.createQuery("from Person", Person.class)
                        .getResultList();

        System.out.println("All Persons:");
        for (Person person : list) {
            System.out.println(person);
        }

        // -------- UPDATE --------
        tx.begin();

        Person updatePerson = em.find(Person.class, 7812);
        if (updatePerson != null) {
            updatePerson.setName("Updated FIN");
            updatePerson.setSalary(9999.99);
        }

        tx.commit();

        System.out.println("After Update: " + em.find(Person.class, 7812));

        // -------- DELETE --------
        tx.begin();

        Person deletePerson = em.find(Person.class, 7812);
        if (deletePerson != null) {
            em.remove(deletePerson);
        }

        tx.commit();

        System.out.println("After Delete: " +
                em.find(Person.class, 7812));  // will print null

        // Close resources
        em.close();
        emf.close();
    }
}