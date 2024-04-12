package io.github.liuziyuan.retrofit.spring.loadbalancer.backend.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LoadBalancerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerBackendApplication.class, args);
	}

}
