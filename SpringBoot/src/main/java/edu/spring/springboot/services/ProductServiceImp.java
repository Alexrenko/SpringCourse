package edu.spring.springboot.services;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    @Autowired
    public ProductRepository repository;


    @Override
    @Transactional
    public void saveProduct(Product product) {
        repository.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(long id) {
        if (repository.existsById(id))
            repository.delete(repository.findById(id).get());
    }
}
