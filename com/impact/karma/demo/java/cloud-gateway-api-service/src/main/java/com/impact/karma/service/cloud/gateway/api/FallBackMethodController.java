package com.impact.karma.service.cloud.gateway.api;

import static java.text.MessageFormat.format;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallBackMethod")
public class FallBackMethodController {

	private static String FALLBACK_MESSAGE = "{0} is taking longer than expected. Please try again later";
	
	private String genericFallbackMethod(String serviceName) {
		return format(FALLBACK_MESSAGE, serviceName);
	}

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBack() {
		return genericFallbackMethod("USER-SERVICE");
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBack() {
		return genericFallbackMethod("DEPARTMENT-SERVICE");
	}
	
	@GetMapping("/rabbitmqProducerFallBack")
	public String rabbitmqProducerFallBack() {
		return genericFallbackMethod("MSG-RABBITMQ-PRODUCER");
	}
	
	@GetMapping("/kafkaProducerFallBack")
	public String kafkaProducerFallBack() {
		return genericFallbackMethod("MSG-KAFKA-PRODUCER");
	}
	
}
