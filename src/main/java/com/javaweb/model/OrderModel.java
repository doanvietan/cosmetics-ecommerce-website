package com.javaweb.model;

import java.sql.Timestamp;
import java.util.List;

public class OrderModel {
	private int orderId;
	private int userId;
	private Timestamp orderDate;
	private String status;
	private long totalAmount;
	private String paymentMethod;
	private List<OrderItemModel> orderItem;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public List<OrderItemModel> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemModel> orderItem) {
		this.orderItem = orderItem;
	}
	
	
	
}
