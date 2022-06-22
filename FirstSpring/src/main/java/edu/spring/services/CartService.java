package edu.spring.services;

import edu.spring.entities.Cart;
import edu.spring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CartService {

    @Autowired
    private ApplicationContext context;
    private ArrayList<Cart> carts = new ArrayList<>();

    public Cart getCart() {
        return context.getBean(Cart.class);
    }

    public void printProducts(Cart cart) {
        System.out.println("Моя корзина:");
        if (cart.getProducts().size() > 0) {
            for(Product product : cart.getProducts()) {
                System.out.println(String.format("\t%d\t%-15s\t%.2f$",
                        product.getId(), product.getTitle(), product.getCost()));
            }
        } else
            System.out.println("\tКорзина пуста");
        System.out.println("---------------------------------");
    }
}
