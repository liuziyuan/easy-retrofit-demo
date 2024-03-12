package io.github.liuziyuan.retrofit.spring.boot3.reactor.samples.api;

import io.github.liuziyuan.retrofit.core.extension.BaseInterceptor;
import lombok.SneakyThrows;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author liuziyuan
 */
public class LoggingInterceptor extends BaseInterceptor {

    private HttpLoggingInterceptor httpLoggingInterceptor;

    public LoggingInterceptor() {
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @SneakyThrows
    @Override
    protected Response executeIntercept(Chain chain) {
        return httpLoggingInterceptor.intercept(chain);
    }
}
