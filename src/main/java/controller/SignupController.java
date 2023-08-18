package controller;

import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.MemberServiceImpl;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String str = "/WEB-INF/view/member/jsp/signup.jsp";
        request.getRequestDispatcher(str)
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String str = "";

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
//        String role = request.getParameter("role");

        Member m = new Member(userId, password, address, tel);
//        m.setUsername(username);
//        m.setPassword(password);
//        m.setAddress(address);
//        m.setPhoneNumber(tel);
//        m.setRole(role);

        MemberServiceImpl ser = new MemberServiceImpl();
        int result = ser.register(m);

        if (result > 0) {
            System.out.println("회원가입 성공");
            str = "/WEB-INF/view/member/jsp/login.jsp";
        } else {
            System.out.println("회원가입 실패");
            str = "/WEB-INF/view/member/jsp/signup.jsp";
        }
        // forward
        request.getRequestDispatcher(str).forward(request, response);
    }
}