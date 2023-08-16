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
import entity.Purchase;
import service.BasketService;
import service.BasketServiceImpl;
import service.PurchaseService;
import service.PurchaseServiceImpl;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PurchaseService purchaseService = null;
	BasketService basketSerivce = null;

	public PurchaseController() {
		// TODO Auto-generated constructor stub
		basketSerivce = new BasketServiceImpl();
		purchaseService = new PurchaseServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("listPurchase")) {
			List<Purchase> list = null;
			list = purchaseService.getPurchases();
			request.setAttribute("list", list);

			str = "/WEB-INF/view/purchase/.jsp";
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
		if (command.equals("buy")) {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			Basket basket = basketSerivce.getByUsername(username);

			Purchase purchase = new Purchase();
			purchase.setP_memberId(basket.getB_memberId());
			purchase.setTitle(basket.getTitle());
			purchase.setPrice(basket.getPrice());
			purchase.setQuantity(basket.getQuantity());

			purchaseService.buy(purchase);

			str = "/WEB-INF/view/purchase/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}
