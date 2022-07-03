package com.microservices.cloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCloudGatewayApplication.class, args);
	}

}
