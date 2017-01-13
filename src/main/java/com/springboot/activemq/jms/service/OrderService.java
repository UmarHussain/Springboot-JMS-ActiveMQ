package com.springboot.activemq.jms.service;


import com.springboot.activemq.jms.model.InventoryResponse;
import com.springboot.activemq.jms.model.Order;

import java.util.Map;

public interface OrderService {
	public void sendOrder(Order order);
	
	public void updateOrder(InventoryResponse response);
	
	public Map<String, Order> getAllOrders();
}
