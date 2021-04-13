package com.impact.karma.messaging.mq.activemq.classic.consumer.service;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;

public interface OrderService {

	public void processOrder(Product product);
}