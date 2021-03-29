package com.impact.karma.messaging.mq.rabbitqm.producer;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/mq/rabbitmq")
public class MessagePublisherController {

	@Autowired
	private RabbitTemplate template;
	
	private static final String MESSAGE_PUBLISHED_PATTERN = "Message published";
	
	@PostMapping("/publish")
	public String publish(@RequestBody CustomMessage message) {
		message.setId(UUID.randomUUID().toString());
		message.setDateTime(new Date());
		template.convertAndSend(
				MqConfig.EXCHANGE_NAME,
				MqConfig.ROUTING_KEY_NAME,
				message
		);
		log.info(MESSAGE_PUBLISHED_PATTERN +"\n"+ message);
		return MESSAGE_PUBLISHED_PATTERN;
	}
}

