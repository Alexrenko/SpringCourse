package edu.spring;

import edu.spring.entities.Shop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("edu.spring");

        Shop shop = context.getBean(Shop.class);
        shop.start();
    }

}
