package com.impact.karma.messaging.mq.activemq.classic.producer.service;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;

public interface ProductService {
	 
    public void sendProduct(Product product);
}