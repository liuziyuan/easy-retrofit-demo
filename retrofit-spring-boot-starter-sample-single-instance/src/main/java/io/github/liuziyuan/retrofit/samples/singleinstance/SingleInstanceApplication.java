package io.github.liuziyuan.retrofit.samples.singleinstance;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.singleinstance.api")
@SpringBootApplication
public class SingleInstanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingleInstanceApplication.class, args);

    }
}
