package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;

/**
 * @author liuziyuan
 */
@RetrofitInterceptor(handler = MyRetrofitInterceptor1.class)
public interface MiddleApi extends BaseApi, OtherApi {
}
