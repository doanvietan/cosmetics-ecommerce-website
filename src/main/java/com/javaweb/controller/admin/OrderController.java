package com.javaweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.IOrderDAO;
import com.javaweb.model.OrderModel;
@WebServlet(urlPatterns ="/admin-order")
public class OrderController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderDAO orderDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAllOrder(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// updateOrderStatus
		int orderId = Integer.parseInt(req.getParameter("orderId")) ;
		String action = req.getParameter("action");
		
		if ("confirm".equals(action)) {
		    orderDAO.updateOrderStatus(orderId, "completed");
		} else if ("cancel".equals(action)) {
		    orderDAO.updateOrderStatus(orderId, "canceled");
		}
		resp.sendRedirect("admin-order");	}
	
	private void findAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> orders = orderDAO.getAllOrders();
		req.setAttribute("Order", orders);
		req.getRequestDispatcher("/views/admin/order.jsp").forward(req, resp);
	}
	
}
