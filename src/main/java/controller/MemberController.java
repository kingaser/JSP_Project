package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Member;
import service.MemberService;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");

		if (command.equals("signup")) {

			String username = request.getParameter("username");
			String password = request.getParameter("passowrd");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String role = request.getParameter("role");

			Member m = new Member();
			m.setUsername(username);
			m.setPassword(password);
			m.setAddress(address);
			m.setPhoneNumber(phoneNumber);
			m.setRole(role);

			MemberService ser = new MemberService();
			int result = ser.register(m);

			if (result > 0) {
				System.out.println("회원가입 성공");
				str = "/WEB-INF/view/member/login.jsp";
			} else {
				System.out.println("회원가입 실패");
				str = "/WEB-INF/view/member/signup.jsp";
			}
			// forward
			request.getRequestDispatcher(str).forward(request, response);
		} else if (command.equals("login")) {
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

			Member login = new MemberService().login(m);

			if (login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				System.out.println("로그인 성공");
				str = "/WEB-INF/view/member/list.jsp";
			} else {
				System.out.println("로그인 실패");
				str = "/WEB-INF/view/member/login.jsp";
			}
			// forward
			request.getRequestDispatcher(str).forward(request, response);
		}
	}
}
