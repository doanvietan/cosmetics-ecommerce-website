package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IProductInCartDAO;
import com.javaweb.dto.ProductInCartDTO;
import com.javaweb.model.ProductModel;

public class ProductInCartDAO implements IProductInCartDAO{

	@Override
	public List<ProductInCartDTO> getProductsInCart(int userId) {
		List<ProductInCartDTO> result = new ArrayList<>();
		String sql = "SELECT p.product_id, p.product_name, p.product_description, p.product_price, " +
                "p.product_quantity, p.product_sold_quantity, p.product_image, p.category_id, " +
                "c.cart_quantity " +
                "FROM products p " +
                "JOIN carts c ON p.product_id = c.product_id " +
                "WHERE c.user_id = ?";
		try (Connection con = DatabaseDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel product = new ProductModel();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductDescription(rs.getString("product_description"));
                product.setProductPrice(rs.getInt("product_price"));
                product.setProductQuantity(rs.getInt("product_quantity"));
                product.setProductSoldQuantity(rs.getInt("product_sold_quantity"));
                product.setProductImage(rs.getString("product_image"));
                product.setCategoryId(rs.getInt("category_id"));

                int cartQuantity = rs.getInt("cart_quantity");

                ProductInCartDTO dto = new ProductInCartDTO(product, cartQuantity);
                result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
