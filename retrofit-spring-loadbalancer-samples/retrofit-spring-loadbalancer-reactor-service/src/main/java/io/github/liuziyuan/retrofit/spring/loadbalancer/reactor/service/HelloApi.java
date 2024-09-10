package io.github.liuziyuan.retrofit.spring.loadbalancer.reactor.service;

import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.core.annotation.RetrofitPath;
import io.github.easyretrofit.extension.spring.cloud.loadbalancer.RetrofitLoadBalancer;
import io.reactivex.Observable;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
@RetrofitBuilder(baseUrl = "${app.url.host}",
        addCallAdapterFactory = RxJava2CallAdapterFactoryBuilder.class,
        addConverterFactory = GsonConverterFactoryBuilder.class)
@RetrofitPath("${app.url.prefix}")
@RetrofitLoadBalancer(name = "${app.cloud.name}", extensions = @RetrofitInterceptorParam(sort = 10))
public interface HelloApi {

    @GET("hello/{message}")
    Mono<HelloBean> hello(@Path("message") String message);

    @GET("hello/{message}")
    Observable<HelloBean> hello2(@Path("message") String message);

    @GET("hello/{message}")
    Call<HelloBean> hello3(@Path("message") String message);
}
