package controller;

import entity.Member;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/member")
public class AdminMemberController extends HttpServlet {
    private MemberService memberService;
    private HttpSession session;

    public AdminMemberController() {
        memberService = new MemberServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/view/member/admin/jsp/member-manager.jsp";
//        session.getAttribute("login");
        List<Member> memberList = memberService.selectAll();
        request.setAttribute("memberList", memberList);

        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String memberId = request.getParameter("memberId");

        memberService.deleteMember(memberId);

        response.setHeader("response.ok", "true");
        response.sendRedirect("/admin/member");
    }
}
