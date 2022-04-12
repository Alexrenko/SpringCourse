package org.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Products", urlPatterns = "/products")

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.printf("<h1> Список товаров: </h1>");
        writer.printf("<table>");
        writer.println("<tr><th> id </th><th> Название </th><th> Цена </th></tr>");
        for (Product p : getProducts()) {
            String format = "<tr>" +
                                "<td width=\"50\" align=\"center\"> %d </td>" +
                                "<td> %s </td>" +
                                "<td width=\"120\" align=\"center\"> %.2f руб. </td>" +
                            "</tr>";
            writer.println(String.format(format, p.id, p.title, p.cost));
        }
        writer.printf("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.getWriter().printf("<h1>New POST requesto</h1>");
    }

    private ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Жесткий диск", 6540.00));
        products.add(new Product(2, "Оперативная память", 8300.00));
        products.add(new Product(3, "Процессор", 9760.00));
        products.add(new Product(4, "Материнская плата", 5600.00));
        products.add(new Product(5, "CD-ROM", 2240.00));
        products.add(new Product(6, "Видеокарта", 12600.00));
        products.add(new Product(7, "Сетевая карта", 1300.00));
        products.add(new Product(8, "Блок питания", 3530.00));
        products.add(new Product(9, "Клавиатура", 2600.00));
        products.add(new Product(10, "Монитор", 8350.00));
        return products;
    }

    class Product {
        int id;
        String title;
        double cost;

        public Product(int id, String title, double cost) {
            this.id = id;
            this.title = title;
            this.cost = cost;
        }
    }
}