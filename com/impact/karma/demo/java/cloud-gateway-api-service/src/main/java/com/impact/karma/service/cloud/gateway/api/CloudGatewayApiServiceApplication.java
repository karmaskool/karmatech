package com.impact.karma.service.cloud.gateway.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient is more specific
@EnableHystrix
public class CloudGatewayApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApiServiceApplication.class, args);
	}

}
