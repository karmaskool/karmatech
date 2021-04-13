package com.impact.karma.messaging.mq.activemq.classic.bom;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String name;
	private int quantity;

}
