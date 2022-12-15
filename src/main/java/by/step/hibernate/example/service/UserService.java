package by.step.hibernate.example.service;

import by.step.hibernate.example.dao.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {

    public List<User> getAllUsers () {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            return session.createQuery("from user", User.class).list();
        }
    }

    public void saveUser (User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
