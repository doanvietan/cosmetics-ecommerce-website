package com.javaweb.dto;

import com.javaweb.model.ProductModel;

public class ProductInCartDTO {
    private ProductModel product;
    private int cartQuantity;

    public ProductInCartDTO(ProductModel product, int cartQuantity) {
        this.product = product;
        this.cartQuantity = cartQuantity;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
