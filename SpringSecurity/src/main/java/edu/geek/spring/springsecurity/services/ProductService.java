package edu.geek.spring.springsecurity.services;

import edu.geek.spring.springsecurity.entities.Product;
import edu.geek.spring.springsecurity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Product getProduct(long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    @Transactional
    public void delete(long id) {
        repository.delete(repository.findById(id).get());
    }

}
