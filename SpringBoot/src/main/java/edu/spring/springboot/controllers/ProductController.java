package edu.spring.springboot.controllers;

import edu.spring.springboot.entities.Product;
import edu.spring.springboot.repository.ProductRepository;
import edu.spring.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    //получение товара по id [ GET .../app/products/{id} ]
    @GetMapping("/products/{id}")
    public String getProductById(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("product", service.getProductById(id));
        return "/product";
    }

    //получение всех товаров [ GET .../app/products ]
    @GetMapping("/products")
    public String getProducts(@RequestParam(defaultValue = "0") String min,
                              @RequestParam(defaultValue = "9000000") String max,
                              Model model) {
        model.addAttribute("productList", service.getSelection(min, max));
        model.addAttribute("newProduct", new Product());
        return "products";
    }

    //создание нового товара [ POST .../app/products ]
    @PostMapping("/create")
    public String createProduct(Product product) {
        service.saveProduct(product);
        return "redirect:products";
    }

    //удаление товара по id.[ GET .../app/products/delete/{id} ]
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable(value = "id") long id) {
        service.deleteProductById(id);
        return "redirect:/products";
    }

}
