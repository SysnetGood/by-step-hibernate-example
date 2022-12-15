package by.step.hibernate.example.service;

import by.step.hibernate.example.dao.models.Address;
import by.step.hibernate.example.dao.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressService {

    public List<Address> getAllAddrese () {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            return session.createQuery("from address", Address.class).list();
        }
    }

    public void saveAddress (Address address) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(address);
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
