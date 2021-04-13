package com.impact.karma.messaging.mq.activemq.classic.bom;

import java.io.Serializable;

import lombok.Data;

@Data
public class InventoryResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productId;
    private int returnCode;
    private String comment;
     
}