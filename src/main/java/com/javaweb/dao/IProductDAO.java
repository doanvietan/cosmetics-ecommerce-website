package com.javaweb.dao;

import java.util.List;

import com.javaweb.model.ProductModel;

public interface IProductDAO {
	List<ProductModel> productFindAll();
	ProductModel productFindById(int productId);
	boolean productInsert(ProductModel product);
	boolean productUpdate(ProductModel product);
	boolean productDelete(int productId);
	boolean updateProductQuantity(int productId, int quantitySold);
}
