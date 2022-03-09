package io.github.liuziyuan.retrofit.samples.inherit.api;

import io.github.liuziyuan.retrofit.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.hello.url}")
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface OtherApi {
}
