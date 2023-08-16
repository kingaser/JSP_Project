package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Member;
import entity.Product;
import service.MemberService;
import service.MemberServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = null;

	public ProductController() {
		// TODO Auto-generated constructor stub
		productService = new ProductServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String str = "";
		String command = request.getParameter("command");
		if (command.equals("index")) {

			str = "/WEB-INF/view/product/.jsp";
		} else if (command.equals("listProduct")) {
			List<Product> list = null;
			list = productService.getProducts();
			request.setAttribute("list", list);

			str = "/WEB-INF/view/product/.jsp";
		} else if (command.equals("detailProduct")) {
			Product product = null;
			String title = request.getParameter("title");
			product = productService.getProductByTitle(title);
			request.setAttribute("product", product);

			str = "/WEB-INF/view/product/.jsp";
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

			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String productcontent = request.getParameter("productcontent");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");

			Part filePart = request.getPart("image");
			String fileName = filePart.getSubmittedFileName();
			String savePath = request.getServletContext().getRealPath("/upload");

			String filePath = savePath + File.separator + fileName;

			Product product = new Product();
			product.setTitle(title);
			product.setAuthor(author);
			product.setProductcontent(productcontent);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setImage(filePath);
			productService.register(product);

			str = "/WEB-INF/view/product/.jsp";
		} else if (command.equals("editProduct")) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String productcontent = request.getParameter("productcontent");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");

			Part filePart = request.getPart("image");
			String fileName = filePart.getSubmittedFileName();
			String savePath = request.getServletContext().getRealPath("/upload");

			String filePath = savePath + File.separator + fileName;

			Product product = new Product(title, author, productcontent, price, quantity, filePath);
			productService.editProduct(product);

			str = "/WEB-INF/view/product/.jsp";
		} else if (command.equals("delProduct")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			productService.deleteProduct(productId);

			str = "/WEB-INF/view/product/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}
