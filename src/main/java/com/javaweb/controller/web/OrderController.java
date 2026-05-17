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

import com.javaweb.dao.IOrderDAO;
import com.javaweb.model.OrderModel;
@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderDAO orderDAO;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");
	    if(userId != null) {
	    	findByOrder(req, resp, userId);
	    }else {
	    	req.getRequestDispatcher("/views/web/order.jsp").forward(req, resp);
	    }
		
		
		
	}

	private void findByOrder(HttpServletRequest req, HttpServletResponse resp, Integer userId) throws IOException, ServletException {
		List<OrderModel> orders = orderDAO.getOrdersByUserId(userId);
		req.setAttribute("Order", orders);
		req.getRequestDispatcher("/views/web/order.jsp").forward(req, resp);
	}
	
	
}
