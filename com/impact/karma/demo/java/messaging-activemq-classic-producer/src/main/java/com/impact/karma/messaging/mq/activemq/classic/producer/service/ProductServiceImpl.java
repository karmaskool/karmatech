package com.impact.karma.messaging.mq.activemq.classic.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;
import com.impact.karma.messaging.mq.activemq.classic.producer.MessageSender;

import lombok.extern.slf4j.Slf4j;

@Service("productService")
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private MessageSender messageSender;

	@Override
	public void sendProduct(Product product) {
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("Application Producer: sending order request {}", product);
		messageSender.sendMessage(product);
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}