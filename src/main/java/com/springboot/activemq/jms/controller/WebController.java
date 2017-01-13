package com.springboot.activemq.jms.controller;

import com.springboot.activemq.jms.client.JmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@Autowired
	JmsClient jsmClient;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jsmClient.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/receive")
	public String receive(){
		return jsmClient.receive();
	}
}
