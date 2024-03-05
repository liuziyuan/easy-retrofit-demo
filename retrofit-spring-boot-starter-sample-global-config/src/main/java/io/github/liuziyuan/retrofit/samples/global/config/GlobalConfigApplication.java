package io.github.liuziyuan.retrofit.samples.global.config;

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
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.global.config.api")
@SpringBootApplication
public class GlobalConfigApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(GlobalConfigApplication.class, args);
        final ConfigurableEnvironment environment = run.getEnvironment();
        log.info("swagger-ui URL: http://localhost:{}/swagger-ui/index.html", environment.getProperty("server.port"));
    }
}
