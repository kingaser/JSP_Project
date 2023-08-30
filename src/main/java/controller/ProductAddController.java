package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 50 * 5
)
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

        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data; charset=UTF-8");

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");

        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();

        String filePath = "\\view\\product\\images\\" + fileName;
        String content = request.getParameter("content");

        Product product = new Product(title, author, price, quantity, filePath, content);

        productService.register(product);

        response.sendRedirect("/");

    }
}
