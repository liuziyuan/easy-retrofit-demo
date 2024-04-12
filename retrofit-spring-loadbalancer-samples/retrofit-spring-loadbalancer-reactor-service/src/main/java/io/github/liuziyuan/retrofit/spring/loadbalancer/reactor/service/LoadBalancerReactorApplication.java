package io.github.liuziyuan.retrofit.spring.loadbalancer.reactor.service;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableRetrofit("io.github.liuziyuan.retrofit.spring.cloud.reactor.service")
@EnableDiscoveryClient
@SpringBootApplication
public class LoadBalancerReactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerReactorApplication.class, args);
	}

}
