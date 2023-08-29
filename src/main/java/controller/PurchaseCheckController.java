package controller;


import entity.Member;
import entity.Product;
import entity.Purchase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;
import service.ProductServiceImpl;
import service.PurchaseService;

import java.io.IOException;

@WebServlet("/purchase/check")
public class PurchaseCheckController extends HttpServlet {
    HttpSession session;
    ProductService productService;
    PurchaseService purchaseService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        productService = new ProductServiceImpl();

        Product product = productService.getProduct(id);
        int pid = product.getProductId();
        request.setAttribute("p", product);

        session = request.getSession();
        request.setAttribute("login", session);

        String url = "/view/purchase/jsp/purchase.jsp";
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String str = "";

        int productId = Integer.parseInt(request.getParameter("productId"));
        String purchaseQuantity = request.getParameter("quantity");
        session = request.getSession();
        Member member = (Member) session.getAttribute("login");

        Product product = productService.getProduct(productId);

        Purchase purchase = new Purchase();
        purchase.setP_memberId(member.getMemberId());
        purchase.setTitle(product.getTitle());
        purchase.setPrice(String.valueOf(Integer.parseInt(product.getPrice()) * Integer.parseInt(purchaseQuantity)));
        purchase.setQuantity(purchaseQuantity);

        purchaseService.buy(purchase);
    }
}
