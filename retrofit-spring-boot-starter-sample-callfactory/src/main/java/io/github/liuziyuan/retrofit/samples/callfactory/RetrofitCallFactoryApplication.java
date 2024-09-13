package io.github.liuziyuan.retrofit.samples.callfactory;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.builder.api")
@SpringBootApplication
public class RetrofitCallFactoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetrofitCallFactoryApplication.class, args);
    }
}
