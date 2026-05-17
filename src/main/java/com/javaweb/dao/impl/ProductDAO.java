package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IProductDAO;
import com.javaweb.model.ProductModel;

public class ProductDAO implements IProductDAO{
	
	@Override
	public List<ProductModel> productFindAll() {
		List<ProductModel> results = new ArrayList<>();
		String sql = "Select * from products";
		Connection connection = DatabaseDAO.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					ProductModel productModel = new ProductModel();
					productModel.setProductId(resultSet.getInt(1));
					productModel.setProductName(resultSet.getString(2));
					productModel.setProductDescription(resultSet.getString(3));
					productModel.setProductPrice(resultSet.getInt(4));
					productModel.setProductQuantity(resultSet.getInt(5));
					productModel.setProductSoldQuantity(resultSet.getInt(6));
					productModel.setProductImage(resultSet.getString(7));
					productModel.setCategoryId(resultSet.getInt(8));
					results.add(productModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(connection != null) {connection.close();}
					if(statement != null) {statement.close();}
					if(resultSet != null) {resultSet.close();}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return results;
	}

	
	@Override
	public ProductModel productFindById(int productId) {
	    ProductModel productModel = null;
	    String sql = "SELECT * FROM products WHERE product_id = ?";
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    if(connection != null) {
	        try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            statement.setInt(1, productId); 
	            resultSet = statement.executeQuery();
	            if(resultSet.next()) {
	                productModel = new ProductModel();
	                productModel.setProductId(resultSet.getInt(1));
	                productModel.setProductName(resultSet.getString(2));
	                productModel.setProductDescription(resultSet.getString(3));
	                productModel.setProductPrice(resultSet.getInt(4));
	                productModel.setProductQuantity(resultSet.getInt(5));
	                productModel.setProductSoldQuantity(resultSet.getInt(6));
	                productModel.setProductImage(resultSet.getString(7));
	                productModel.setCategoryId(resultSet.getInt(8));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(connection != null) {connection.close();}
	                if(statement != null) {statement.close();}
	                if(resultSet != null) {resultSet.close();}
	            } catch (Exception e2) {
	                // Handle exception
	            }
	        }
	    }
	    return productModel;
	}
	
	@Override
	public boolean productInsert(ProductModel product) {
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;

	    try {
	        String sql = "INSERT INTO products (product_name, product_description, product_price, product_quantity, product_sold_quantity, product_image, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        connection.setAutoCommit(false);
	        statement = connection.prepareStatement(sql);
	        
	        statement.setString(1, product.getProductName());
	        statement.setString(2, product.getProductDescription());
	        statement.setInt(3, product.getProductPrice());
	        statement.setInt(4, product.getProductQuantity());
	        statement.setInt(5, 0);
	        statement.setString(6, product.getProductImage());
	        statement.setInt(7, product.getCategoryId());

	        int rowsInserted = statement.executeUpdate();
	        connection.commit();
	        return rowsInserted > 0;
	    } catch (Exception e) {
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        try { if (statement != null) statement.close(); } catch (Exception e) {}
	        try { if (connection != null) connection.close(); } catch (Exception e) {}
	    }

	    return false;
	}
	
	@Override
	public boolean productUpdate(ProductModel product) {
	    String sql = "UPDATE products SET product_name = ?, product_description = ?, product_price = ?, product_quantity = ?, product_sold_quantity = ?, product_image = ?, category_id = ? WHERE product_id = ?";
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;

	    try {
	        statement = connection.prepareStatement(sql);
	        statement.setString(1, product.getProductName());
	        statement.setString(2, product.getProductDescription());
	        statement.setInt(3, product.getProductPrice());
	        statement.setInt(4, product.getProductQuantity());
	        statement.setInt(5, product.getProductSoldQuantity());
	        statement.setString(6, product.getProductImage());
	        statement.setInt(7, product.getCategoryId());
	        statement.setInt(8, product.getProductId());

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
	public boolean productDelete(int productId) {
	    String sql = "DELETE FROM products WHERE product_id = ?";
	    Connection connection = DatabaseDAO.getConnection();
	    PreparedStatement statement = null;

	    try {
	        connection.setAutoCommit(false);
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, productId);

	        int rowsDeleted = statement.executeUpdate();
	        connection.commit();

	        return rowsDeleted > 0;
	    } catch (Exception e) {
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (Exception rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try { if (statement != null) statement.close(); } catch (Exception e) {}
	        try { if (connection != null) connection.close(); } catch (Exception e) {}
	    }

	    return false;
	}
	
	@Override
	public boolean updateProductQuantity(int productId, int quantitySold) {
		String sql = "UPDATE products " +
				"SET product_quantity = product_quantity - ?, " +
				"    product_sold_quantity = product_sold_quantity + ? " +
				"WHERE product_id = ? AND product_quantity >= ?";
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, quantitySold);
			ps.setInt(2, quantitySold);
			ps.setInt(3, productId);
			ps.setInt(4, quantitySold);
	        int affectedRows = ps.executeUpdate();
	        return affectedRows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	
}

