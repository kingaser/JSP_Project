package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.File;
import java.io.IOException;

@WebServlet("/product/add")
public class ProductAddController extends HttpServlet {

    ProductService productService;

    public ProductAddController() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "/view/product/regist/jsp/product-regist.jsp";
        request.getRequestDispatcher(str)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String productContent = request.getParameter("productContent");
        String price_ = request.getParameter("price");
        String quantity_ = request.getParameter("quantity");

        int price = 0;
        if (price_ != null && price_.equals(""))
            price = Integer.parseInt(price_);

        int quantity = 0;
        if (quantity_ != null && quantity_.equals(""))
            quantity = Integer.parseInt(quantity_);

        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();
        String savePath = request.getServletContext().getRealPath("/upload");

        String filePath = savePath + File.separator + fileName;

        Product product = new Product(title, author, productContent, price, quantity, filePath);
        productService.register(product);

        response.sendRedirect("/");

    }
}
