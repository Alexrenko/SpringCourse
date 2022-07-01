package edu.spring.springboot.dao;

import edu.spring.springboot.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CustomerDao implements Dao<Customer> {

    @Autowired
    private EntityManager em;

    public CustomerDao() {

    }

    @Override
    public void create(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public Customer findById(Long id) {
        em.getTransaction().begin();
        Customer customer = em.createQuery("SELECT a FROM Customer a WHERE a.id = :id",
                Customer.class).setParameter("id", id).getSingleResult();
        em.getTransaction().commit();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        em.getTransaction().begin();
        List<Customer> list = em.createQuery("SELECT a FROM Customer a", Customer.class).getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Customer a WHERE a.id = :id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }

}
