package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IOrderDAO;
import com.javaweb.model.OrderItemModel;
import com.javaweb.model.OrderModel;

public class OrderDAO implements IOrderDAO{

	@Override
	public int insertOrder(int userId, long totalAmount, String paymentMethod) {
		int orderId = 0;
		Connection con = DatabaseDAO.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
            String sql = "INSERT INTO orders (user_id, order_date, status, total_amount, payment_method) VALUES (?, NOW(), 'processing', ?, ?)";
            con.setAutoCommit(false);
			statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, userId);
			statement.setLong(2, totalAmount);
			statement.setString(3, paymentMethod);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			if(rs.next()) {
				orderId = rs.getInt(1);
			}
			con.commit();
		} catch (Exception e) {
			if(con != null) {
				try {con.rollback();} catch (Exception e2) {e2.printStackTrace();}
			}
		}finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (statement != null) statement.close(); } catch (Exception e) {}
			try { if (con != null) con.close(); } catch (Exception e) {}
		}		
		return orderId;
	}
	
	public List<OrderModel> getOrdersByUserId(int userId) {
	    List<OrderModel> orders = new ArrayList<>();
	    String sql = "SELECT * FROM orders WHERE user_id = ?";
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	OrderModel order = new OrderModel();
	            order.setOrderId(rs.getInt("order_id"));
	            order.setUserId(rs.getInt("user_id"));
	            order.setOrderDate(rs.getTimestamp("order_date"));
	            order.setStatus(rs.getString("status"));
	            order.setTotalAmount(rs.getLong("total_amount"));
	            order.setPaymentMethod(rs.getString("payment_method"));
	            order.setOrderItem(getOrderItemsByOrderId(order.getOrderId()));
	            orders.add(order);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return orders;
	}
	
	public List<OrderModel> getAllOrders() {
	    List<OrderModel> orders = new ArrayList<>();
	    String sql = "SELECT * FROM orders" +
				" ORDER BY order_id DESC";
		try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            OrderModel order = new OrderModel();
	            order.setOrderId(rs.getInt("order_id"));
	            order.setUserId(rs.getInt("user_id"));
	            order.setOrderDate(rs.getTimestamp("order_date"));
	            order.setStatus(rs.getString("status"));
	            order.setTotalAmount(rs.getLong("total_amount"));
	            order.setPaymentMethod(rs.getString("payment_method"));
	            order.setOrderItem(getOrderItemsByOrderId(order.getOrderId()));
	            orders.add(order);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return orders;
	}

	public List<OrderItemModel> getOrderItemsByOrderId(int orderId) {
	    List<OrderItemModel> list = new ArrayList<>();
	    String sql = "SELECT oi.*, p.product_name, p.product_image FROM order_items oi " +
	                 "JOIN products p ON oi.product_id = p.product_id " +
	                 "WHERE oi.order_id = ?" ;
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, orderId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            OrderItemModel item = new OrderItemModel();
	            item.setOrderItemId(rs.getInt("order_item_id"));
	            item.setOrderId(rs.getInt("order_id"));
	            item.setProductId(rs.getInt("product_id"));
	            item.setQuantity(rs.getInt("quantity"));
	            item.setPrice(rs.getLong("price"));
	            item.setProductName(rs.getString("product_name"));
	            item.setProductImage(rs.getString("product_Image"));
	            list.add(item);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public boolean updateOrderStatus(int orderId, String newStatus) {
	    String sql = "UPDATE orders SET status = ? WHERE order_id = ?";
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, newStatus);
	        ps.setInt(2, orderId);
	        int affectedRows = ps.executeUpdate();
	        return affectedRows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
