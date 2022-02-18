package io.github.liuziyuan.retrofit.samples.singleinstance;

import io.github.liuziyuan.retrofit.annotation.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.singleinstance.api")
@SpringBootApplication
public class SingleInstanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingleInstanceApplication.class, args);
    }
}
