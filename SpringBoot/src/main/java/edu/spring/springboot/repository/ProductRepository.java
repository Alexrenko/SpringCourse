package edu.spring.springboot.repository;

import edu.spring.springboot.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements Repository<Product> {

    private final List<Product> products = new ArrayList<>();
    private int idCount = 1;

    {
        products.add(new Product(idCount++, "Монитор", 1.0));
        products.add(new Product(idCount++, "Мышь", 2.0));
        products.add(new Product(idCount++, "Клавиатура", 3.0));
        products.add(new Product(idCount++, "Колонки", 4.0));
        products.add(new Product(idCount++, "Жесткий диск", 5.0));
    }

    @Override
    public Product getProduct(int id) {
        for(Product product : products)
            if(id == product.getId())
                return product;

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public int getIdCount() {
        return idCount++;
    }
}
