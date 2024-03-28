package io.github.liuziyuan.retrofit.samples.awesome.api;


import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface DynamicBaseApi {


}
