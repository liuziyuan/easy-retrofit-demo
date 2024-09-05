package io.github.liuziyuan.integration;


import io.github.easyretrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */

@EnableRetrofit
@SpringBootApplication
public class IntegrationStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegrationStartApplication.class, args);
    }
}
