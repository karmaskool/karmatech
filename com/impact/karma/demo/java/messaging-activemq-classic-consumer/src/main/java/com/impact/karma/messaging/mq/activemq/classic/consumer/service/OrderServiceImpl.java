package com.impact.karma.messaging.mq.activemq.classic.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.impact.karma.messaging.mq.activemq.classic.bom.InventoryResponse;
import com.impact.karma.messaging.mq.activemq.classic.bom.Product;
import com.impact.karma.messaging.mq.activemq.classic.consumer.MessageSender;

import lombok.extern.slf4j.Slf4j;

@Service("orderService")
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MessageSender messageSender;

	@Override
	public void processOrder(Product product) {

		InventoryResponse response = prepareResponse(product);
		log.info("Application Consumer Inventory : sending order confirmation {}", response);
		messageSender.sendMessage(response);
	}

	private InventoryResponse prepareResponse(Product product) {
		InventoryResponse response = new InventoryResponse();
		response.setProductId(product.getProductId());
		response.setReturnCode(HttpStatus.OK.value());
		response.setComment("Order Processed successfully");
		return response;
	}

}