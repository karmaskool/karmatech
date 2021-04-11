package com.impact.karma.container.k8s.dekorate.manifest.generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/k8s/dekorate")
@Slf4j
public class K8sDekorateManifestGeneratorController {

	@GetMapping("/hello")
	public String k8sHello() {
		log.info("K8sDekorateManifestGeneratorController.k8sHello()");
		return "Hello k8s dekorate";
	}
}
