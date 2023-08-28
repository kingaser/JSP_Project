package controller;

import entity.Member;
import entity.Product;
import entity.Purchase;
import entity.Reply;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/purchase/detail")
public class PurchaseDetailController extends HttpServlet {

    MemberService memberService;
    ProductService productService;
    PurchaseService purchaseService;
    ReplyService replyService;

    public PurchaseDetailController() {
        this.productService = new ProductServiceImpl();
        this.replyService = new ReplyServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.getProduct(id);
        int pid = product.getProductId();
        request.setAttribute("p", product);

        List<Reply> replyList = replyService.getReplies(pid);
        request.setAttribute("replyList", replyList);

        String url = "/view/detail/jsp/details.jsp";
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String str = "";
        HttpSession session = request.getSession();
        int memberId = (int) session.getAttribute("memberId");
        Member member = memberService.getMemberById(memberId);

        Product product = productService.getProductByTitle("title");

        Purchase purchase = new Purchase(member.getMemberId(),
                product.getTitle(),
                product.getPrice(),
                product.getQuantity());

        purchaseService.buy(purchase);

        str = "/view/purchase/.jsp";
        request.getRequestDispatcher(str).forward(request, response);
    }
}
