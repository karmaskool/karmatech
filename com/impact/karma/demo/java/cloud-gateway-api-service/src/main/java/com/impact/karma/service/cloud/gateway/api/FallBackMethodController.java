package com.impact.karma.service.cloud.gateway.api;

import static java.text.MessageFormat.format;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallBackMethod")
public class FallBackMethodController {

	private static String FALLBACK_MESSAGE = "{0} is taking longer than expected. Please try again later";
	
	private String genericFallback(String serviceName) {
		return format(FALLBACK_MESSAGE, serviceName);
	}

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return genericFallback("USER-SERVICE");
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return genericFallback("DEPARTMENT-SERVICE");
	}
	
	@GetMapping("/rabbitmqProducerFallBack")
	public String rabbitmqProducerFallBackMethod() {
		return genericFallback("RABBITMQ-PRODUCER");
	}
	
}
