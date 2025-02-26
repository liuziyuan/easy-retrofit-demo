package io.github.liuziyuan.retrofit.spring.boot.web.samples;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
