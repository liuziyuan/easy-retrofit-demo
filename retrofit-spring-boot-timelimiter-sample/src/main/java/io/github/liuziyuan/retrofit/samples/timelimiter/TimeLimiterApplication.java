package io.github.liuziyuan.retrofit.samples.timelimiter;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.timelimiter.api")
@SpringBootApplication
public class TimeLimiterApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeLimiterApplication.class, args);
    }
}
