package edu.spring.springboot.controllers;

import edu.spring.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("product", repository.getProduct(id));
        return "product";
    }

}
