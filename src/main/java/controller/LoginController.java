package controller;

import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.MemberServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = "/WEB-INF/view/member/jsp/login.jsp";
        request.getRequestDispatcher(str)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      아래 코드를 써줘야 글씨 안깨짐
        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member m = new Member();
        m.setUsername(username);
        m.setPassword(password);

        Member login = new MemberServiceImpl().login(m);

        if (login != null) {
            session = request.getSession();
            session.setAttribute("login", login);
//          15분 세션유지
            session.setMaxInactiveInterval(15 * 60);
            System.out.println("로그인 성공");

            response.sendRedirect("/");
        } else {
            System.out.println("로그인 실패");
            response.sendRedirect("/login?loginFailed=true");
        }
        // forward
    }

}
