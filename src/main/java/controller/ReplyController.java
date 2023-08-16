package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Basket;
import entity.Member;
import entity.Reply;
import service.BasketService;
import service.BasketServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.ReplyService;
import service.ReplyServiceImpl;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReplyService replyService = null;
	BasketService basketSerivce = null;

	public ReplyController() {
		// TODO Auto-generated constructor stub
		replyService = new ReplyServiceImpl();
		basketSerivce = new BasketServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("listReply")) {
			List<Reply> list = null;
			list = replyService.getReplies();
			request.setAttribute("list", list);
			str = "/WEB-INF/view/reply/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("registerForm")) {

			str = "/WEB-INF/view/reply/.jsp";
		} else if (command.equals("register")) {
			String replycontent = request.getParameter("replycontent");

			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			Basket basket = basketSerivce.getByUsername(username);

			int r_memberId = basket.getMemberId();
			int r_productId = basket.getProductId();

			Reply reply = new Reply();
			reply.setR_memberId(r_memberId);
			reply.setR_productId(r_productId);
			reply.setReplycontent(replycontent);
			replyService.addReply(reply);

			str = "/WEB-INF/view/reply/.jsp";
		} else if (command.equals("delBasket")) {
			HttpSession session = request.getSession();
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			replyService.delReply(replyId);

			str = "/WEB-INF/view/reply/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}
