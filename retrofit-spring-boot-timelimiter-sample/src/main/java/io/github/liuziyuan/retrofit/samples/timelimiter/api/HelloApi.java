package io.github.liuziyuan.retrofit.samples.timelimiter.api;

import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.extension.timelimiter.core.annotation.EnableTimeLimiter;
import io.github.easyretrofit.extension.timelimiter.core.annotation.TimeLimiter;
import io.github.liuziyuan.retrofit.samples.timelimiter.HelloBean;
import io.github.liuziyuan.retrofit.samples.timelimiter.config.GsonConvertFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.timelimiter.config.OkHttpBuilderFactory;
import io.github.liuziyuan.retrofit.samples.timelimiter.config.ReactorCallAdapterFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.timelimiter.config.SimpleBodyCallAdapterFactoryBuilder;
import retrofit2.http.GET;

//@EnableTimeLimiter(fallback = TimeLimiterApiFallBack.class, extensions = @RetrofitInterceptorParam(sort = 10))
@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addCallAdapterFactory = {SimpleBodyCallAdapterFactoryBuilder.class, ReactorCallAdapterFactoryBuilder.class},
        addConverterFactory = GsonConvertFactoryBuilder.class,
        client = OkHttpBuilderFactory.class
)
public interface HelloApi {

    @TimeLimiter(resourceName = "errorTimeout", fallbackMethod = "errorTimeout")
    @GET("backend/v1/error/timeout")
    HelloBean errorTimeout();

}
