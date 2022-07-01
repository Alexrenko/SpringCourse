package edu.spring.springboot.dao;

import edu.spring.springboot.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ProductDao implements Dao<Product> {

    @Autowired
    private EntityManager em;

    public ProductDao() {
    }

    @Override
    public void create(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public Product findById(Long id) {
        em.getTransaction().begin();
        Product product = em.createQuery("SELECT a FROM Product a WHERE a.id = :id",
                Product.class).setParameter("id", id).getSingleResult();
        em.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT a FROM Product a", Product.class).getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public void saveOrUpdate(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Product a WHERE a.id = :id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }

}
