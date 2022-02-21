package io.github.liuziyuan.retrofit.samples.awesome;

import io.github.liuziyuan.retrofit.annotation.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.quickstart.api")
@SpringBootApplication
public class AwesomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwesomeApplication.class, args);
    }
}
