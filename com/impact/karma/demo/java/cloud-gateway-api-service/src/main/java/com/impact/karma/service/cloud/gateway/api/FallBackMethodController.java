package com.impact.karma.service.cloud.gateway.api;

import static java.text.MessageFormat.format;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	private static String FALLBACK_MESSAGE = "{0} is taking longer than expected. Please try again later";

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return format(FALLBACK_MESSAGE, "USER-SERVICE");
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return format(FALLBACK_MESSAGE, "DEPARTMENT-SERVICE");
	}
}
