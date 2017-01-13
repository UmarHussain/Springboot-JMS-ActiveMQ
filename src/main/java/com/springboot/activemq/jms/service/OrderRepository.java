package com.springboot.activemq.jms.service;


import com.springboot.activemq.jms.model.Order;

import java.util.Map;

public interface OrderRepository {

	public void putOrder(Order order);
	
	public Order getOrder(String orderId);
	
	public Map<String, Order> getAllOrders();
}
