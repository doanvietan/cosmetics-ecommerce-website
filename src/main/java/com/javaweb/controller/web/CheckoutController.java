package com.javaweb.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.dao.ICartDAO;
import com.javaweb.dao.IOrderDAO;
import com.javaweb.dao.IOrderItemDAO;
import com.javaweb.dao.IProductDAO;
import com.javaweb.dao.IProductInCartDAO;
import com.javaweb.dao.IUserDAO;
import com.javaweb.dto.ProductInCartDTO;
@WebServlet(urlPatterns ="/checkout")
public class CheckoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Inject
	private IUserDAO userDAO;
	@Inject
	private IProductInCartDAO productInCartDAO;
	@Inject
	private IOrderDAO orderDAO;
	@Inject
	private IOrderItemDAO orderItemDAO;
	@Inject 
	private ICartDAO cartDAO;
	@Inject
	private IProductDAO productDAO;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			req.setAttribute("User", userDAO.findById(userId));
			req.setAttribute("ProductInCart", productInCartDAO.getProductsInCart(userId));
		}
		req.getRequestDispatcher("/views/web/checkout.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");
	    
	    if(userId != null) {
	    	placeOrder(req, resp, userId);
	    }
	}

	private void placeOrder(HttpServletRequest req, HttpServletResponse resp, Integer userId) throws IOException {
		String paymentMethod = req.getParameter("payment-method");
	    List<ProductInCartDTO> cartItems = productInCartDAO.getProductsInCart(userId);
	    long totalAmount = 0;
	    for(ProductInCartDTO item :cartItems) {
	    	totalAmount += item.getCartQuantity() * item.getProduct().getProductPrice();
	    }
	    int orderId = orderDAO.insertOrder(userId, totalAmount, paymentMethod);
	    
	    for(ProductInCartDTO item :cartItems) {
	    	orderItemDAO.insertOrderItem(orderId, item.getProduct().getProductId(), item.getCartQuantity(), item.getProduct().getProductPrice());
	    	productDAO.updateProductQuantity(item.getProduct().getProductId(), item.getCartQuantity());
	    }
	    cartDAO.clearCart(userId);
	    
	    resp.sendRedirect("order");
	    
	}
}
