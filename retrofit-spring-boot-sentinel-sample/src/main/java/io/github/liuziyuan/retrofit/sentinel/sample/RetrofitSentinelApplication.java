package io.github.liuziyuan.retrofit.sentinel.sample;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRetrofit
@SpringBootApplication
public class RetrofitSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetrofitSentinelApplication.class, args);
    }

}
