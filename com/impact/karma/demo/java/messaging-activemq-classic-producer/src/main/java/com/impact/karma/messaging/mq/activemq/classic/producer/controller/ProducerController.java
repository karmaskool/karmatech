package com.impact.karma.messaging.mq.activemq.classic.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;
import com.impact.karma.messaging.mq.activemq.classic.producer.MessageSender;
import com.impact.karma.messaging.mq.activemq.classic.producer.util.BasicUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("mq/activemq/classic")
@Slf4j
public class ProducerController {
	
	@Autowired
	private MessageSender sender;
	
	private static final String MESSAGE_PUBLISHED_PATTERN = "Message published";
	
	@PostMapping("/publish")
	public Product publish(@RequestBody Product data) {
		data.setProductId(BasicUtil.getUniqueId());
		sender.sendMessage(data);
		log.info(MESSAGE_PUBLISHED_PATTERN +"\n"+ data);
		return data;
	}

}
