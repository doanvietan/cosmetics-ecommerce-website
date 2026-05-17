package com.javaweb.dao;

import com.javaweb.model.CartModel;

public interface ICartDAO {
	Integer cartInsert(CartModel cart);
	boolean cartDelete(int userId, int productId);
    boolean cartUpdateQuantity(int userId, int productId, int newQuantity, int productQuantity);
    boolean clearCart(int userId);
}
