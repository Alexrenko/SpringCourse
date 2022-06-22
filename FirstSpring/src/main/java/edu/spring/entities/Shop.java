package edu.spring.entities;

import edu.spring.repository.ProductRepository;
import edu.spring.services.CartService;
import edu.spring.services.ProductService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Shop {

    private final CartService cartService;
    private final ProductService productService;

    private final BufferedReader reader;
    private Cart cart;

    public Shop(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
        cart = cartService.getCart();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        try {
            while (true) {
                productService.printProducts();
                cartService.printProducts(cart);
                printMenu();

                String input = reader.readLine();
                if (input.equals("4"))
                    return;
                else
                    customerChoice(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {}
        }

    }

    private void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 Взять новую корзину");
        System.out.println("2 Добавить товар в корзину");
        System.out.println("3 Удалить товар из корзины");
        System.out.println("4 Выход");
        System.out.println();
        System.out.print("Выберите пункт меню: ");
    }

    private void customerChoice(String input) throws IOException {
        switch (input) {
            case ("1") :
                cart = cartService.getCart();
                break;
            case ("2") :
                putProduct();
                break;
            case ("3") :
                removeProduct();
                break;
        }
    }

    private void putProduct() throws IOException {
        System.out.print("Введите ID товара: ");
        int id = Integer.parseInt(reader.readLine());
        cart.put(productService.getProduct(id));
    }

    private void removeProduct() throws IOException {
        System.out.print("Введите ID товара: ");
        int id = Integer.parseInt(reader.readLine());
        cart.remove(id);
    }
}