package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptorParam;
import io.github.liuziyuan.retrofit.extension.sentinel.core.annotation.RetrofitSentinelResource;
import io.github.liuziyuan.retrofit.extension.sentinel.core.interceptor.RetrofitSentinelInterceptor;


@RetrofitBuilder(baseUrl = "http://localhost:9300")
@RetrofitSentinelResource(fallback = RetrofitSentinelApiFallBack.class,
        extensions = @RetrofitInterceptorParam(sort = 10))
public interface BaseApi {


}
