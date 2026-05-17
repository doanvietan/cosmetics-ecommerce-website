package com.javaweb.dao;

import java.util.List;

import com.javaweb.dto.ProductInCartDTO;

public interface IProductInCartDAO {
	List<ProductInCartDTO> getProductsInCart(int userId);
}
