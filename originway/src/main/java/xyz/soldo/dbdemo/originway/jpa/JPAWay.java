package xyz.soldo.dbdemo.originway.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import xyz.soldo.dbdemo.originway.model.User;

public class JPAWay {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User();
        user.setNick_name("blackbrin2");
        user.setEmail("blackbrin2@example.com");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
