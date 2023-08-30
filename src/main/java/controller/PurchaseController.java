package controller;

import entity.Basket;
import entity.Member;
import entity.Product;
import entity.Purchase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
    PurchaseService purchaseService;
    ProductService productService;
    HttpSession session;

    public PurchaseController() {
        productService = new ProductServiceImpl();
        purchaseService = new PurchaseServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        session = request.getSession();
        Member member = (Member) session.getAttribute("login");
        session.setAttribute("login", session.getAttribute("login"));
        List<Purchase> list = purchaseService.getPurchases(member.getMemberId());

        request.setAttribute("list", list);

        String str = "/view/purchase/jsp/purchase-list.jsp";
        // forward
        request.getRequestDispatcher(str).forward(request, response);
    }
}