package edu.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class Config {

    @Bean
    public EntityManagerFactory getFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Bean
    @Scope("prototype")
    public EntityManager getEM(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

}
