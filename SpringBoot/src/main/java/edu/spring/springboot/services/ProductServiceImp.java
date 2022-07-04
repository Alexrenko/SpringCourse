package edu.spring.springboot.services;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    @Autowired
    public ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getSelection(String strMin, String strMax) {
        int min = Integer.parseInt(strMin);
        int max = Integer.parseInt(strMax);
        return repository.findByPriceBetween(min, max);
    }

    @Override
    @Transactional
    public void deleteProductById(long id) {
        if (repository.existsById(id))
            repository.delete(repository.findById(id).get());
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        repository.save(product);
    }
}
