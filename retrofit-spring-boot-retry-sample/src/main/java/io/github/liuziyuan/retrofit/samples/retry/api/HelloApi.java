package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.extension.retry.core.annotation.EnableRetry;
import io.github.easyretrofit.extension.retry.core.annotation.Retry;
import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import io.github.liuziyuan.retrofit.samples.retry.config.GsonConvertFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.retry.config.SimpleBodyCallAdapterFactoryBuilder;
import retrofit2.http.GET;

@EnableRetry(fallback = RetryApiFallBack.class, extensions = @RetrofitInterceptorParam(sort = 10))
@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addCallAdapterFactory = SimpleBodyCallAdapterFactoryBuilder.class,
        addConverterFactory = GsonConvertFactoryBuilder.class
)
//@Retry(resourceName = "helloApi", config = HelloRetryConfig.class)
public interface HelloApi {

    @Retry(resourceName = "error400", fallbackMethod = "error400")
    @GET("backend/v1/error/400")
    HelloBean error400();

    @Retry(resourceName = "error404")
    @GET("backend/v1/error/404")
    HelloBean error404();
}
