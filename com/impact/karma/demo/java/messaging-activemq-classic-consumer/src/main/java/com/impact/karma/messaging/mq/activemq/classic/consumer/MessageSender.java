package com.impact.karma.messaging.mq.activemq.classic.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.impact.karma.messaging.mq.activemq.classic.bom.InventoryResponse;

@Component
public class MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(final InventoryResponse inventoryResponse) {

		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(inventoryResponse);
				return objectMessage;
			}
		});
	}

}