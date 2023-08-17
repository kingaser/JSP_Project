package controller;

import entity.Basket;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BasketService;
import service.BasketServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/basket")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BasketService basketService = null;
	MemberService memberService = null;

	public BasketController() {
		// TODO Auto-generated constructor stub
		basketService = new BasketServiceImpl();
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("listBasket")) {
			List<Basket> list = null;
			list = basketService.getBaskets();
			request.setAttribute("list", list);

			str = "/WEB-INF/view/basket/jsp/basket-list.jsp";
		} else if (command.equals("detailBasket")) {
			Basket basket = null;
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			basket = basketService.getByUsername(username);
			request.setAttribute("basket", basket);
			str = "/WEB-INF/view/basket/.jsp";
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
		if (command.equals("register")) {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			Member member = memberService.getMemberByUsername(username);
			int b_memberId = member.getMemberId();
			int b_productId = Integer.parseInt(request.getParameter("productId"));

			Basket basket = new Basket();
			basket.setB_memberId(b_memberId);
			basket.setB_productId(b_productId);
			basketService.addBasket(basket);

			str = "/WEB-INF/view/basket/.jsp";
		} else if (command.equals("delBasket")) {
			int basketId = Integer.parseInt(request.getParameter("basketId"));
			basketService.deleteBasket(basketId);

			str = "/WEB-INF/view/basket/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}
