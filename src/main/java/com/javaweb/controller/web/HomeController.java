package com.javaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.dao.ICartDAO;
import com.javaweb.dao.IProductDAO;
import com.javaweb.model.CartModel;


@WebServlet(urlPatterns = {"/home", "/dang-nhap"})
public class HomeController extends HttpServlet{

	@Inject
	private ICartDAO cartDAO;
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDAO productDAO;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("Product", productDAO.productFindAll());
		
		String action = req.getParameter("action");
		 if ("logout".equals(action)) {
	            logout(req, resp);
	            return;
	        }

		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addToCart(req, resp);	
  	}
	
	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int productId = Integer.parseInt(req.getParameter("productId"));
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");

            if (userId != null) {
                CartModel cartModel = new CartModel(productId, userId, 1);
                cartDAO.cartInsert(cartModel);
                resp.sendRedirect("cart");
            } else {
                resp.sendRedirect("login");
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("home?error=invalid_product_id");
        }
    }
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  
        }
        response.sendRedirect(request.getContextPath() + "/home");  
    }
	
}
