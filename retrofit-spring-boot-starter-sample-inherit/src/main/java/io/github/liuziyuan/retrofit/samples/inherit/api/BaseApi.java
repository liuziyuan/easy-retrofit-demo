package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */

@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface BaseApi {
}
