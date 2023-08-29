package controller;

import entity.Basket;
import entity.Member;
import entity.Reply;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BasketService;
import service.BasketServiceImpl;
import service.ReplyService;
import service.ReplyServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ReplyService replyService = null;
    BasketService basketService = null;

    public ReplyController() {
        // TODO Auto-generated constructor stub
        replyService = new ReplyServiceImpl();
        basketService = new BasketServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        String str = "";
//        String command = request.getParameter("command");
//        if (command.equals("listReply")) {
//            List<Reply> list = null;
//            list = replyService.getReplies();
//            request.setAttribute("list", list);
//            str = "/view/reply/.jsp";
//        }
//        request.getRequestDispatcher(str).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String str = "";

        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("login");
        String replyContent = request.getParameter("replyContent");
        int r_productId = Integer.parseInt(request.getParameter("productId"));

        Reply reply = new Reply();

        reply.setR_memberId(member.getMemberId());
        reply.setR_productId(r_productId);
        reply.setReplyContent(replyContent);
        replyService.addReply(reply);

    }
}