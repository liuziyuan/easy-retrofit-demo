package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.samples.inherit.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */

@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface BaseApi {

    @GET("{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
