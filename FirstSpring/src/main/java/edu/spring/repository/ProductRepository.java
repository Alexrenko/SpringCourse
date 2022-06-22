package edu.spring.repository;

import edu.spring.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements Repository<Product>{

    private ArrayList<Product> products;
    private int idCount = 1;


    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(idCount++, "Мышь", 1.0));
        products.add(new Product(idCount++, "Клавиатура", 2.0));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for(Product product : products)
            if (id == product.getId())
                return product;

        return null;
    }

    @PostConstruct
    public void addingProducts() {
        products.add(new Product(idCount++, "Монитор", 3.0));
        products.add(new Product(idCount++, "Колонки", 4.0));
        products.add(new Product(idCount++, "Жесткий диск", 5.0));
    }
}
