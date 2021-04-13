package com.impact.karma.messaging.mq.activemq.artemis.producer;

import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MessagingActivemqArtemisProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MessagingActivemqArtemisProducerApplication.class, args);
		EmbeddedActiveMQ artemisServer = run.getBean(EmbeddedActiveMQ.class);
		try {
			artemisServer.start();
			log.info("ActiveMQServer started");
		} catch (Exception e) {
			log.error("ActiveMQServer failed to start: "+e.getMessage());
			e.printStackTrace();
		}
	}

}
