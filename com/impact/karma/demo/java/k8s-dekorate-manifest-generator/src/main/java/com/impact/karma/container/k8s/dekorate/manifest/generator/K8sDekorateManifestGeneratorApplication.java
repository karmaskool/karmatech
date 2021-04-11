package com.impact.karma.container.k8s.dekorate.manifest.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.Port;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@KubernetesApplication(
		ports = @Port(name = "http", containerPort = 8201),
		labels = @Label(key="version", value = "v1"),
		expose = false
)
@Slf4j
@Data
public class K8sDekorateManifestGeneratorApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(K8sDekorateManifestGeneratorApplication.class, args);
		K8sDekorateManifestGeneratorConfiguration config = run.getBean(K8sDekorateManifestGeneratorConfiguration.class);
		log.info("ConfigurableApplicationContext: " +config.getPort());
	}

}
