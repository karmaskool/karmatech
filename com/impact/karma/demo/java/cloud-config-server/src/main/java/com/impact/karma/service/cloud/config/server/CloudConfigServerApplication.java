package com.impact.karma.service.cloud.config.server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigServerApplication {
	
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext app = SpringApplication.run(CloudConfigServerApplication.class, args);
		app.getBean(CloudConfigServerConfiguration.class).printGitConfig();
	}

}
