package controller;

import entity.Product;
import entity.Reply;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/purchase/detail")
public class PurchaseDetailController extends HttpServlet {

    ProductService productService;
    ReplyService replyService;

    public PurchaseDetailController() {
        this.productService = new ProductServiceImpl();
        this.replyService = new ReplyServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.getProduct(id);
        int pid = product.getProductId();
        request.setAttribute("p", product);

        List<Reply> replyList = replyService.getReplies(pid);
        request.setAttribute("replyList", replyList);

        String url = "/view/detail/jsp/details.jsp";
        request.getRequestDispatcher(url)
                .forward(request, response);
    }
}
