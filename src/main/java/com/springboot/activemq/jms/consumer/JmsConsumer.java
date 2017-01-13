package com.springboot.activemq.jms.consumer;

import com.springboot.activemq.jms.model.InventoryResponse;
import com.springboot.activemq.jms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

import javax.jms.JMSException;

@Component
public class JmsConsumer {

	static final Logger LOG = LoggerFactory.getLogger(JmsConsumer.class);
	//@Autowired
	//JmsTemplate jmsTemplate;

	@Autowired
	OrderService orderService;

	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;
	
	//@Value("${jms.queue.destination}")
	private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

	@Value("${jms.queue.destination}")
	private String queue;


	@JmsListener(destination = ORDER_RESPONSE_QUEUE)
	public void receive(final Message<InventoryResponse> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Application : headers received : {}", headers);

		InventoryResponse response = message.getPayload();
		LOG.info("Application : response received : {}",response);

		orderService.updateOrder(response);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public String receive(){

		return (String)jmsMessagingTemplate.getJmsTemplate().receiveAndConvert(queue);
	}
}
