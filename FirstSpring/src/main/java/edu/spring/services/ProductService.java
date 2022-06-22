package edu.spring.services;

import edu.spring.entities.Product;
import edu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProduct(int id) {
        return repository.getById(id);
    }

    public void printProducts() {
        System.out.println("---------------------------------");
        System.out.println("Список товаров в магазине:");
        for(Product product : this.repository.getAll())
            System.out.println(String.format("\t%d\t%-15s\t%.2f$",
                    product.getId(), product.getTitle(), product.getCost()));
        System.out.println("---------------------------------");
    }
}
