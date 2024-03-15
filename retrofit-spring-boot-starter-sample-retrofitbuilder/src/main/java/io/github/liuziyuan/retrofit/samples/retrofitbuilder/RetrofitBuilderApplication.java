package io.github.liuziyuan.retrofit.samples.retrofitbuilder;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.retrofitbuilder.api")
@SpringBootApplication
public class RetrofitBuilderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitBuilderApplication.class, args);
    }
}
