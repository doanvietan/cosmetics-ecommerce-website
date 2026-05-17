package com.javaweb.dao;

import java.util.List;

import com.javaweb.model.OrderItemModel;

public interface IOrderItemDAO {
    void insertOrderItem(int orderId, int productId, int quantity, long price);
    List<OrderItemModel> getOrderItems(int orderId);
}
