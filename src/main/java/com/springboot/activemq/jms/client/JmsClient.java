package com.springboot.activemq.jms.client;

import com.springboot.activemq.jms.model.Order;

public interface JmsClient {
	 void send(String msg);
	 String receive();
	 void send(Order order);
}
