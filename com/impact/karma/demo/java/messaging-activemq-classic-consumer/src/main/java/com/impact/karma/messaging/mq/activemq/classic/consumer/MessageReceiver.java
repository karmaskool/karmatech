package com.impact.karma.messaging.mq.activemq.classic.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;
import com.impact.karma.messaging.mq.activemq.classic.consumer.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver implements MessageListener {

	@Autowired
	public MessageConverter messageConverter;

    @Autowired
    private OrderService orderService;
    
	@Override
    public void onMessage(Message message) {
        try {
            log.info("-----------------------------------------------------");
            Product product = (Product) messageConverter.fromMessage(message);
            log.info("Application : order received : {}",product);  
            orderService.processOrder(product);
            log.info("-----------------------------------------------------");
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
}
