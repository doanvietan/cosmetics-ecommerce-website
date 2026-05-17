package com.javaweb.dao;

import java.util.List;

import com.javaweb.model.OrderModel;

public interface IOrderDAO {
	int insertOrder(int userId, long totalAmount, String paymentMethod);
	List<OrderModel> getOrdersByUserId(int userId);
	List<OrderModel> getAllOrders();
	boolean updateOrderStatus(int orderId, String newStatus);
}
