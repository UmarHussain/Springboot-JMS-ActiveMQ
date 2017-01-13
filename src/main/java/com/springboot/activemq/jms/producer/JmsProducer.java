package com.springboot.activemq.jms.producer;

import com.springboot.activemq.jms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jms.queue.destination}")
	String destinationQueue;

	@Value("${jms.queue.order}")
	String orderQueue;
	
	public void send(String msg){
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}


	public void send(Order order){
		jmsTemplate.convertAndSend(orderQueue,order);
	}
}