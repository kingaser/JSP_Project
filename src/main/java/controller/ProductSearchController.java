package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/searchProduct")
public class ProductSearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = null;

    public ProductSearchController() {
        // TODO Auto-generated constructor stub
        productService = new ProductServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String title = request.getParameter("title");
        List<Product> list = productService.getSearchProducts(title);
        request.setAttribute("list", list);

        String str = "/view/product/jsp/index.jsp";

        // forward
        request.getRequestDispatcher(str).forward(request, response);
    }
}
