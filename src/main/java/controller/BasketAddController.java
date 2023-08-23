package controller;

import entity.Basket;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BasketService;
import service.BasketServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/basket/register")
public class BasketAddController extends HttpServlet {
    BasketService basketService;
    MemberService memberService;

    public BasketAddController() {
        // TODO Auto-generated constructor stub
        basketService = new BasketServiceImpl();
        memberService = new MemberServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        Member member = (Member) session.getAttribute("login");
        int b_memberId = member.getMemberId();
        int b_productId = Integer.parseInt(request.getParameter("productId"));

        Basket basket = new Basket();
        basket.setB_memberId(b_memberId);
        basket.setB_productId(b_productId);
        basketService.addBasket(basket);

        response.sendRedirect("/basket?command=listBasket");
//        request.getRequestDispatcher(str).forward(request, response);
    }
}
