package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */

@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface BaseApi {
}
