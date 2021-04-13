package com.impact.karma.messaging.mq.activemq.artemis.producer.config;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.impact.karma.messaging.mq")
public class ServerConfiguration {

//	@Bean
	public ActiveMQServer activeMQArtemisServer() {
		ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl().setPersistenceEnabled(true)
				.setJournalDirectory("target/journal").setSecurityEnabled(false));
		return server;
	}

	@Bean
	public EmbeddedActiveMQ embeddedActiveMQArtemisServer() {
		return new EmbeddedActiveMQ();
	}

}
