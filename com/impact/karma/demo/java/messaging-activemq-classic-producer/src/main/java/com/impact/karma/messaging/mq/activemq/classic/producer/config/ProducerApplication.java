package com.impact.karma.messaging.mq.activemq.classic.producer.config;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.impact.karma.messaging.mq.activemq.classic.bom.Product;
import com.impact.karma.messaging.mq.activemq.classic.producer.service.ProductService;
import com.impact.karma.messaging.mq.activemq.classic.producer.util.BasicUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class ProducerApplication {

	private static AtomicInteger id = new AtomicInteger();

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProducerApplication.class, args);
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MessagingConfiguration.class);

		ProductService productService = (ProductService) context.getBean("productService");
		Product product = getProduct();
		log.info("Application Producer: sending order {}", product);
		productService.sendProduct(product);
	}

	private static Product getProduct() {
		Product p = new Product();
		p.setName("Product " + id.incrementAndGet());
		p.setProductId(BasicUtil.getUniqueId());
		p.setQuantity(2);
		return p;
	}
}