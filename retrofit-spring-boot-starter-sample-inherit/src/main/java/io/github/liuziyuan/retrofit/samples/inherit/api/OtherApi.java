package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.hello.url}")
//@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface OtherApi {
}
