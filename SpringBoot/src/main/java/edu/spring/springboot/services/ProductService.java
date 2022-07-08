package edu.spring.springboot.services;

import edu.spring.springboot.entities.Product;


public interface ProductService {

    void saveProduct(Product product);

    void deleteProductById(long id);

}
