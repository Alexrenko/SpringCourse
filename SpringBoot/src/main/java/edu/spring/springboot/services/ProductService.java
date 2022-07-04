package edu.spring.springboot.services;

import edu.spring.springboot.entities.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id);

    List<Product> getAllProducts();

    List<Product> getSelection(String s1, String s2);

    void saveProduct(Product product);

    void deleteProductById(long id);
}
