package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import service.ProductService;
import service.PurchaseService;

import java.io.IOException;

@WebServlet("/purchase/check")
public class PurchaseCheckController extends HttpServlet {
    MemberService memberService;
    ProductService productService;
    PurchaseService purchaseService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.getProduct(id);
        int pid = product.getProductId();
        request.setAttribute("p", product);

        String url = "/view/purchase/jsp/purchase.jsp";
        request.getRequestDispatcher(url)
                .forward(request, response);
    }
}
