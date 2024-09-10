package io.github.liuziyuan.retrofit.spring.loadbalancer.web.service;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.core.annotation.RetrofitPath;
import io.github.easyretrofit.extension.spring.cloud.loadbalancer.RetrofitLoadBalancer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@RetrofitBuilder(baseUrl = "${app.url.host}",
        addCallAdapterFactory = SimpleBodyAdapterFactoryBuilder.class,
        addConverterFactory = GsonConverterFactoryBuilder.class)
@RetrofitPath("${app.url.prefix}")
@RetrofitLoadBalancer(name = "${app.cloud.name}", extensions = @RetrofitInterceptorParam(sort = 10))
public interface HelloApi {

    @GET("hello/{message}")
    HelloBean hello(@Path("message") String message);

    @GET("hello/{message}")
    Call<HelloBean> hello3(@Path("message") String message);
}
