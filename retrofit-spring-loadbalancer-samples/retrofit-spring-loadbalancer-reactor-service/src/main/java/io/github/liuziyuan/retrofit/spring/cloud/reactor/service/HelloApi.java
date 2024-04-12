package io.github.liuziyuan.retrofit.spring.cloud.reactor.service;

import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitUrlPrefix;
import io.github.liuziyuan.retrofit.extension.spring.cloud.loadbalancer.RetrofitLoadBalancer;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitUrlPrefix("${app.url.prefix}")
@RetrofitLoadBalancer(name = "${app.cloud.name}")
public interface HelloApi {

    @GET("hello/{message}")
    Mono<HelloBean> hello(@Path("message") String message);

    @GET("hello/{message}")
    Observable<HelloBean> hello2(@Path("message") String message);

    @GET("hello/{message}")
    Call<HelloBean> hello3(@Path("message") String message);
}
