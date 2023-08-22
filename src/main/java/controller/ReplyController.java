package controller;

import entity.Basket;
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("listReply")) {
			List<Reply> list = null;
			list = replyService.getReplies();
			request.setAttribute("list", list);
			str = "/view/reply/.jsp";
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

			str = "/view/reply/.jsp";
		} else if (command.equals("register")) {

			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			String replyContent = request.getParameter("replyContent");

			Reply reply = new Reply();
			Basket basket = basketService.getByUsername(username);

			int r_memberId = basket.getMemberId();
			int r_productId = basket.getProductId();

			reply.setR_memberId(r_memberId);
			reply.setR_productId(r_productId);
			reply.setReplyContent(replyContent);
			replyService.addReply(reply);

			str = "/view/reply/list.jsp";
		} else if (command.equals("delBasket")) {
			HttpSession session = request.getSession();
			int replyId = Integer.parseInt(request.getParameter("replyId"));
			replyService.delReply(replyId);

			str = "/view/reply/list.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}