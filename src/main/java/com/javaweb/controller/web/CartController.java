package com.javaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.dao.ICartDAO;
import com.javaweb.dao.IProductDAO;
import com.javaweb.dao.IProductInCartDAO;
@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductInCartDAO productInCartDAO;
	@Inject
	private ICartDAO cartDAO;
	@Inject
	private IProductDAO productDAO;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		if (action != null) {
			String productIdParam = req.getParameter("productId");
			if (productIdParam != null) {
				try {
					int productId = Integer.parseInt(productIdParam);
					if ("delete".equals(action)) {
						deleleCartItem(req, resp, userId, productId);
						return;
					} else if ("inc".equals(action)) {
						incQuantity(req, resp, userId, productId);
						return;
					} else if ("dec".equals(action)) {
						decQuantity(req, resp, userId, productId);
						return;
					}
				} catch (NumberFormatException e) {
					resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
					return;
				}
			} else {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product ID");
				return;
			}
		}
		cartView(req, resp);
	}
	
	private void incQuantity(HttpServletRequest req, HttpServletResponse resp, Integer userId, int productId) throws IOException {
		int productQuantity = productDAO.productFindById(productId).getProductQuantity();
		cartDAO.cartUpdateQuantity(userId, productId, 1, productQuantity);
		resp.sendRedirect("cart");
	}

	private void decQuantity(HttpServletRequest req, HttpServletResponse resp, Integer userId, int productId) throws IOException {
		int productQuantity = productDAO.productFindById(productId).getProductQuantity();
		cartDAO.cartUpdateQuantity(userId, productId, -1, productQuantity);
		resp.sendRedirect("cart");
	}

	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void deleleCartItem(HttpServletRequest req, HttpServletResponse resp, Integer userId, int productId) throws IOException {
		cartDAO.cartDelete(userId, productId);
		resp.sendRedirect("cart");
	}

	private void cartView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		if (userId != null) {
			req.setAttribute("ProductInCart", productInCartDAO.getProductsInCart(userId));
			req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		} else {
			req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
		}
	}
	
	
	

}
