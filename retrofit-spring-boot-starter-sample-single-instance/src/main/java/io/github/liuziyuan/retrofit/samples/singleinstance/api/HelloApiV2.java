package io.github.liuziyuan.retrofit.samples.singleinstance.api;

import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.samples.singleinstance.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 * <p><b>{@code ${app.hello.url}} need set in application.yml</b>
 * <p><b>Except baseUrl, other attributes are not required</b>
 *
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.hello.v2.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        addCallAdapterFactory = {RxJavaCallAdapterFactoryBuilder.class})
@RetrofitInterceptor(handler = LoggingInterceptor.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface HelloApiV2 {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
