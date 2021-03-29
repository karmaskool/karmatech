package com.impact.karma.messaging.mq.rabbitqm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageConsumerListener {

	@RabbitListener(queues = MqConfig.QUEUE_NAME)
	public void listener(CustomMessage message) {
		log.info("Message Received\n" + message);
	}
}
