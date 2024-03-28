package io.github.liuziyuan.retrofit.samples.builder;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.builder.api")
@SpringBootApplication
public class RetrofitBuilderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitBuilderApplication.class, args);
    }
}
