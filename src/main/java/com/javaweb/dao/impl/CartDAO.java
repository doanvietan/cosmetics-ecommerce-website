package com.javaweb.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javaweb.dao.ICartDAO;
import com.javaweb.model.CartModel;

public class CartDAO implements ICartDAO{

	@Override
	public Integer cartInsert(CartModel cart) {
		Connection connection = DatabaseDAO.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO carts(user_id, product_id, cart_quantity) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE cart_quantity = cart_quantity + VALUES(cart_quantity);";
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, cart.getUserId());
			statement.setInt(2, cart.getProductId());
			statement.setInt(3, cart.getCartQuantity());
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (statement != null) statement.close(); } catch (Exception e) {}
			try { if (connection != null) connection.close(); } catch (Exception e) {}
		}
		return null;
	}
	
	@Override
	public boolean cartDelete(int userId, int productId) {
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;
	    try {
	        String sql = "DELETE FROM carts WHERE user_id = ? AND product_id = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, userId);
	        statement.setInt(2, productId);
	        int rowsDeleted = statement.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (statement != null) statement.close(); } catch (Exception e) {}
	        try { if (connection != null) connection.close(); } catch (Exception e) {}
	    }
	    return false;
	}
	
	
	@Override
	public boolean cartUpdateQuantity(int userId, int productId, int newQuantity, int productQuantity) {
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;
	    
	    try {
	        String sql = "UPDATE carts SET cart_quantity = cart_quantity + ? WHERE user_id = ? AND product_id = ? AND cart_quantity + ? >= 0 AND cart_quantity + ? <= ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, newQuantity);
	        statement.setInt(2, userId);
	        statement.setInt(3, productId);
	        statement.setInt(4, newQuantity);
	        statement.setInt(5, newQuantity);
	        statement.setInt(6, productQuantity);
	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (statement != null) statement.close(); } catch (Exception e) {}
	        try { if (connection != null) connection.close(); } catch (Exception e) {}
	    }
	    return false;
	}

	@Override
	public boolean clearCart(int userId) {
		Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;
	    try {
	        String sql = "DELETE FROM carts WHERE user_id = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, userId);
	        int rowsDeleted = statement.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (statement != null) statement.close(); } catch (Exception e) {}
	        try { if (connection != null) connection.close(); } catch (Exception e) {}
	    }
	    return false;
	}

	

}
