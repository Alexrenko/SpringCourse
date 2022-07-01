package edu.spring.springboot;

import edu.spring.springboot.dao.CustomerDao;
import edu.spring.springboot.entities.Customer;
import edu.spring.springboot.entities.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
