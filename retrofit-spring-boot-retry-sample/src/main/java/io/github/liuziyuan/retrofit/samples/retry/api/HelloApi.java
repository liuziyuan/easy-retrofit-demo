package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.annotation.RetrofitBuilder;
//import io.github.easyretrofit.core.annotation.RetrofitFallBack;
import io.github.easyretrofit.core.annotation.RetrofitFallBack;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.extension.retry.core.annotation.EnableRetry;
import io.github.easyretrofit.extension.retry.core.annotation.Retry;
import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import io.github.liuziyuan.retrofit.samples.retry.config.GsonConvertFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.retry.config.ReactorCallAdapterFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.retry.config.Rxjava3CallAdapterFactoryBuilder;
import io.github.liuziyuan.retrofit.samples.retry.config.SimpleBodyCallAdapterFactoryBuilder;
import io.reactivex.rxjava3.core.Flowable;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;

@EnableRetry(extensions = @RetrofitInterceptorParam(sort = 10))
@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addCallAdapterFactory = {SimpleBodyCallAdapterFactoryBuilder.class, ReactorCallAdapterFactoryBuilder.class, Rxjava3CallAdapterFactoryBuilder.class},
        addConverterFactory = GsonConvertFactoryBuilder.class
)
@RetrofitFallBack(RetryApiFallBack.class)
public interface HelloApi {

    @GET("/backend/v1/hello/ABC")
    HelloBean hello();

    @Retry(resourceName = "error400")
    @GET("backend/v1/error/400")
    HelloBean error400();

    @Retry(resourceName = "helloMono400")
    @GET("backend/v1/error/400")
    Mono<HelloBean> helloMono400();


    @Retry(resourceName = "helloFlowable400")
    @GET("backend/v1/error/400")
    Flowable<HelloBean> helloFlowable400();


}
