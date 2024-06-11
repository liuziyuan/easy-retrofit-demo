package io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples.api")
@SpringBootApplication
public class RetrofitSpringBootAliyunApiGatewayApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(RetrofitSpringBootAliyunApiGatewayApplication.class, args);
    }
}
