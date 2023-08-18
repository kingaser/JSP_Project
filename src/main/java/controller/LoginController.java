package controller;

import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.MemberServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "/view/member/jsp/login.jsp";
        request.getRequestDispatcher(str)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.equals("")) {
            Cookie c = new Cookie("username", username);
            c.setMaxAge(1 * 1 * 60 * 60); // 만료 기간 1시간(초단위 작성)
            response.addCookie(c);
        } else {
            Cookie c = new Cookie("username", username);
            c.setMaxAge(0); // 0초
            response.addCookie(c);
        }
        Member m = new Member();
        m.setUsername(username);
        m.setPassword(password);

        Member login = new MemberServiceImpl().login(m);

        if (login != null) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            System.out.println("로그인 성공");
            response.sendRedirect("/");
        } else {
            System.out.println("로그인 실패");
            response.sendRedirect("/login");
        }
        // forward
    }
}
