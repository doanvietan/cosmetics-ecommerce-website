package com.javaweb.model;

public class CartModel {
	 private int cartId;
	 private int userId;
	 private int productId;
	 public CartModel(int productId, int userId, int cartQuantity) {
	        this.productId = productId;
	        this.userId = userId;
	        this.cartQuantity = cartQuantity;
	    }
	 
	 public CartModel(int cartId, int productId, int userId, int cartQuantity) {
	        this.cartId = cartId;
	        this.productId = productId;
	        this.userId = userId;
	        this.cartQuantity = cartQuantity;
	    }
	 private int cartQuantity;
	 
	 
	 public int getCartId() {
		 return cartId;
	 }
	 public void setCartId(int cartId) {
		 this.cartId = cartId;
	 }
	 public int getUserId() {
		 return userId;
	 }
	 public void setUserId(int userId) {
		 this.userId = userId;
	 }
	 public int getProductId() {
		 return productId;
	 }
	 public void setProductId(int productId) {
		 this.productId = productId;
	 }
	 public int getCartQuantity() {
		 return cartQuantity;
	 }
	 public void setCartQuantity(int cartQuantity) {
		 this.cartQuantity = cartQuantity;
	 }
	 
}
