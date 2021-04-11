package com.impact.karma.container.k8s.dekorate.manifest.generator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class K8sDekorateManifestGeneratorConfiguration {

	@Value("${server.port}")
	private String port;
}
