package org.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstHTTPServlet", urlPatterns = "/first_http_servlet")

public class FirstHTTPServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstHTTPServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("New GET request");
        resp.getWriter().printf("<h1>New GET request</h1>");
        resp.getWriter().printf("<h1>It is work too :)</h1>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("New POST request");
        resp.getWriter().printf("<h1>New POST requesto</h1>");
    }
}

