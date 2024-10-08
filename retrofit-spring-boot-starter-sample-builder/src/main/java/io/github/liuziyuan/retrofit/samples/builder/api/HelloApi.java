package io.github.liuziyuan.retrofit.samples.builder.api;

import io.github.easyretrofit.core.OverrideRule;
import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.samples.builder.domain.HelloBean;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 * <p><b>{@code ${app.hello.url}} need set in application.yml</b>
 * <p><b>Except baseUrl, other attributes are not required</b>
 *
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.backend.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        addCallAdapterFactory = {RxJavaCallAdapterFactoryBuilder.class, SimpleBodyCallAdapterFactoryBuilder.class, ReactorCallAdapterFactoryBuilder.class},
        callbackExecutor = CallBackExecutorBuilder.class,
        client = OkHttpClientBuilder.class,
        validateEagerly = false,
        globalOverwriteRule = OverrideRule.LOCAL_FIRST)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("backend/v1/hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);

    @POST("backend/v1/hello")
    Observable<HelloBean> helloObservable(@Body HelloBean message);

    @GET("backend/v1/hello/int")
    Observable<Integer> helloIntObservable();

    @GET("backend/v1/hello/int")
    Integer helloIntBody();

    @GET("backend/v1/hello/int")
    Mono<Integer> helloIntMono();
}
