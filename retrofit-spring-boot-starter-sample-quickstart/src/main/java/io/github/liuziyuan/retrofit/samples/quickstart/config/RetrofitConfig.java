package io.github.liuziyuan.retrofit.samples.quickstart.config;

import io.github.liuziyuan.retrofit.RetrofitResourceDefinitionRegistry;
import io.github.liuziyuan.retrofit.annotation.EnableRetrofit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuziyuan
 */
@EnableRetrofit
@Configuration
public class RetrofitConfig {
    @Bean
    public static RetrofitResourceDefinitionRegistry retrofitResourceDefinitionRegistry() {
        return new RetrofitResourceDefinitionRegistry();
    }
}
