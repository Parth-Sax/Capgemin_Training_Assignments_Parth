package capge_one_to_one.app;

import capge_one_to_one.entity.Human;
import capge_one_to_one.entity.Pan;
import capge_one_to_one.entity.Passport;
import capge_one_to_one.entity.Person1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class One_To_One_Main {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.setId(1);
        person1.setName("Tom");

        Pan pan = new Pan();
        pan.setPanNumber(1);
        pan.setPanAddress("Noida");

        person1.setPan(pan);
        pan.setPerson1(person1);

        Human human = new Human();
        human.setId(1);
        human.setName("Tom");

        Passport passport = new Passport();
        passport.setCountry("America");
        passport.setPassportNumber("AMC123");
        // passport.setHuman();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(pan);
        entityManager.persist(person1);

//        entityManager.persist(human);
//        entityManager.persist(passport);

        entityTransaction.commit();
    }
}
