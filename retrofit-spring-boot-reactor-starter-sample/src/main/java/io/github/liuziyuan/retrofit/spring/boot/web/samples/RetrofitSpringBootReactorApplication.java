package io.github.liuziyuan.retrofit.spring.boot.web.samples;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.spring.boot.web.samples.api")
@SpringBootApplication
public class RetrofitSpringBootReactorApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitSpringBootReactorApplication.class, args);
    }
}
