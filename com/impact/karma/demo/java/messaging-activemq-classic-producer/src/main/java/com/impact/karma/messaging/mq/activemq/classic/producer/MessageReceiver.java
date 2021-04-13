package com.impact.karma.messaging.mq.activemq.classic.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.impact.karma.messaging.mq.activemq.classic.bom.InventoryResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver implements MessageListener {

	@Autowired
	public MessageConverter messageConverter;

	@Override
	public void onMessage(Message message) {
		try {
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
			log.info("Application : order response received : {}", response);
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
