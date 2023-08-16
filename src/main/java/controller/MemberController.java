package controller;

import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.MemberServiceImpl;

import java.io.IOException;

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
			str = "/WEB-INF/view/member/signup.jsp";
			request.getRequestDispatcher(str).forward(request, response);

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String role = request.getParameter("role");

			Member m = new Member();
			m.setUsername(username);
			m.setPassword(password);
			m.setAddress(address);
			m.setPhoneNumber(phoneNumber);
			m.setRole(role);

			MemberServiceImpl ser = new MemberServiceImpl();
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

			Member login = new MemberServiceImpl().login(m);

			if (login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				System.out.println("로그인 성공");
				str = "/WEB-INF/view/member/html/list.jsp";
			} else {
				System.out.println("로그인 실패");
				str = "/WEB-INF/view/member/login.jsp";
			}
			// forward
			request.getRequestDispatcher(str).forward(request, response);
		}
	}
}