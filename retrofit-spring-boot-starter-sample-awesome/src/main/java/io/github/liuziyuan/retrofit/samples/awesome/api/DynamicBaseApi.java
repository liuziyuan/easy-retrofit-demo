package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.liuziyuan.retrofit.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface DynamicBaseApi {


}
