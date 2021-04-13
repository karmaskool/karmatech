package com.impact.karma.messaging.mq.activemq.artemis.producer.controller;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.messaging.mq.jms.Receiver;
import com.impact.karma.messaging.mq.jms.Sender;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mq/activemq/artemis")
public class MessagingActiveMqArtemisController {

	@Autowired
	private Sender sender;

	@Autowired
	private Receiver receiver;

	private static final String MESSAGE_PUBLISHED_PATTERN = "Message published";

	@PostMapping("/publish")
	public String publish(@RequestBody Object message) throws JMSException {

		sender.sendOrder("Hello Spring JMS ActiveMQ!");

//		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

		log.info(MESSAGE_PUBLISHED_PATTERN + "\n" + message);
		return MESSAGE_PUBLISHED_PATTERN;
	}
}
