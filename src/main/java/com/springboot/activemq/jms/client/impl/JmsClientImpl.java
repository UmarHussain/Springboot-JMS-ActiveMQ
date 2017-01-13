package com.springboot.activemq.jms.client.impl;

import com.springboot.activemq.jms.model.Order;
import com.springboot.activemq.jms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.activemq.jms.consumer.JmsConsumer;
import com.springboot.activemq.jms.producer.JmsProducer;

@Service
public class JmsClientImpl implements JmsClient {

	@Autowired
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

	@Override
	public void send(Order order) {
		jmsProducer.send(order);
	}

}
