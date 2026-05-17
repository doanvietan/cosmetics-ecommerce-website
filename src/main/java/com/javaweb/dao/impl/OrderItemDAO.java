package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IOrderItemDAO;
import com.javaweb.model.OrderItemModel;

public class OrderItemDAO implements IOrderItemDAO{

	@Override
    public void insertOrderItem(int orderId, int productId, int quantity, long price) {
        try {
            Connection conn = DatabaseDAO.getConnection();
            String sql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.setLong(4, price);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public List<OrderItemModel> getOrderItems(int orderId) {
	    List<OrderItemModel> items = new ArrayList<>();
	    String sql = "SELECT * From order_items WHERE order_id = ?";
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
	            items.add(item);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return items;
	}
	
	
}
