package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.ProductService;
import service.ProductServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/")
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
		if (command == null) {
			List<Product> list = productService.getProducts();
			request.setAttribute("list", list);
			str = "/view/product/jsp/index.jsp";
	    } else if (command.equals("listProduct")) {
			List<Product> list = productService.getProducts();
			request.setAttribute("list", list);


			str = "/view/product/.jsp";
		} else if (command.equals("detailProduct")) {
			String title = request.getParameter("title");
			Product product = productService.getProductByTitle(title);
			request.setAttribute("product", product);

			str = "/view/product/.jsp";
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
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");

			Part filePart = request.getPart("image");
			String fileName = filePart.getSubmittedFileName();
			String savePath = request.getServletContext().getRealPath("/upload");

			String filePath = savePath + File.separator + fileName;

			Product product = new Product(0, title, author, price, quantity, filePath);
//			product.setTitle(title);
//			product.setAuthor(author);
//			product.setPrice(price);
//			product.setQuantity(quantity);
//			product.setImage(filePath);
			productService.register(product);

			str = "/view/product/.jsp";
		} else if (command.equals("editProduct")) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");

			Part filePart = request.getPart("image");
			String fileName = filePart.getSubmittedFileName();
			String savePath = request.getServletContext().getRealPath("/upload");

			String filePath = savePath + File.separator + fileName;

			Product product = new Product(title, author, price, quantity, filePath);
			productService.editProduct(product);

			str = "/view/product/.jsp";
		} else if (command.equals("delProduct")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			productService.deleteProduct(productId);

			str = "/view/product/.jsp";
		}
		request.getRequestDispatcher(str).forward(request, response);
	}
}