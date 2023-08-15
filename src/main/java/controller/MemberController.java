package controller;

import java.io.IOException;
import java.util.List;

import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = null;

	public MemberController() {
		// TODO Auto-generated constructor stub
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("index")) {

			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("signup")) {

			str = "/WEB-INF/view/member/.jsp";
		}
		// forward
		request.getRequestDispatcher(str).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("signup")) {
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");

			Member m = new Member();
			m.setUsername(username);
			m.setPasswd(passwd);
			m.setAddress(address);
			m.setTel(tel);
			memberService.signup(m);

			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("login")) {
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			Member m = new Member();
			m.setUsername(username);
			m.setPasswd(passwd);

			m = memberService.login(username, passwd);
			if (m != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
			}
			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("logout")) {
			HttpSession session = request.getSession(false);
			session.removeAttribute("id");
			session.invalidate();

			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("signout")) {
			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("username");
			memberService.deleteMember(username);
			session.removeAttribute("username");
			session.invalidate();

			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("list")) {
			List<Member> list = null;
			HttpSession session = request.getSession(false);
			list = memberService.getMembers();
			session.setAttribute("list", list);

			str = "/WEB-INF/view/member/.jsp";
		} else if (command.equals("detail")) {
			Member m = null;
			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("username");
			m = memberService.getMemberByUsername(username);
			session.setAttribute("m", m);

			str = "/WEB-INF/view/member/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}
