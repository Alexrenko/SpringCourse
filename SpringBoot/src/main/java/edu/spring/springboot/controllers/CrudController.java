package edu.spring.springboot.controllers;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CrudController {

    @Autowired
    private ProductDao dao;

    @GetMapping("/addproduct.html")
    public String getCreateForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addproduct";
    }

    @PostMapping("/addproduct.html")
    public String createProduct(Product product) {
        dao.create(product);
        return "redirect:products.html";
    }

    @GetMapping("/product/{id}")
    public String readProduct(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("product", dao.findById(id));
        return "product";
    }

    @GetMapping("/change/{id}")
    public String getChangeForm(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("product", dao.findById(id));
        return "changeproduct";
    }

    @PostMapping("/changeproduct.html")
    public String changeProduct(Product product) {
        dao.saveOrUpdate(product);
        return "redirect:products.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable(value = "id") long id) {
        dao.deleteById(id);
        return "redirect:/products.html";
    }

}
