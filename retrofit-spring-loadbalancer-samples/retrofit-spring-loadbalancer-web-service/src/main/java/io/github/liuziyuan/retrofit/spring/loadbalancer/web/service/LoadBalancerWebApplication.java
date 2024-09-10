package io.github.liuziyuan.retrofit.spring.loadbalancer.web.service;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableRetrofit("io.github.liuziyuan.retrofit.spring.loadbalancer.web.service")
@EnableDiscoveryClient
@SpringBootApplication
public class LoadBalancerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerWebApplication.class, args);
	}

}
