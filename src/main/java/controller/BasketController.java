package controller;

import entity.Basket;
import entity.Member;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/basket")
public class BasketController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BasketService basketService = null;
    MemberService memberService = null;

    public BasketController() {
        // TODO Auto-generated constructor stub
        basketService = new BasketServiceImpl();
        memberService = new MemberServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("login");
        List<Basket> list = basketService.getBaskets(member.getMemberId());
        request.setAttribute("list", list);

        request.getRequestDispatcher("/view/basket/jsp/basket-list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int basketId = Integer.parseInt(request.getParameter("basketId"));
        basketService.deleteBasket(basketId);

        response.sendRedirect("/basket");
    }
}
