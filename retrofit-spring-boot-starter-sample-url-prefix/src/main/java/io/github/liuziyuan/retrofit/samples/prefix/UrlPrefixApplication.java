package io.github.liuziyuan.retrofit.samples.prefix;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.url.prefix.api")
@SpringBootApplication
public class UrlPrefixApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlPrefixApplication.class, args);
    }
}
