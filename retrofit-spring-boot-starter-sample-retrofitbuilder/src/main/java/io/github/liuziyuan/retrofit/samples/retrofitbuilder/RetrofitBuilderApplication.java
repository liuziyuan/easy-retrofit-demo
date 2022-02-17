package io.github.liuziyuan.retrofit.samples.retrofitbuilder;

import io.github.liuziyuan.retrofit.annotation.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
