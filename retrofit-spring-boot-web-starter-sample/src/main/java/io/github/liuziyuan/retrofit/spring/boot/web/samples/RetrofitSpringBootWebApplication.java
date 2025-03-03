package io.github.liuziyuan.retrofit.spring.boot.web.samples;

import io.github.easyretrofit.spring.boot.EnableRetrofit;
//import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuziyuan
 */
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.spring.boot.web.samples.api")
@SpringBootApplication
public class RetrofitSpringBootWebApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(RetrofitSpringBootWebApplication.class, args);
    }
}
