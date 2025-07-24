package io.github.liuziyuan.retrofit.spring.boot.web.samples.api;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.easyretrofit.core.annotation.InterceptorType;
import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.core.annotation.RetrofitPath;
//import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
//import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
//import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;
//import io.github.liuziyuan.retrofit.core.annotation.RetrofitUrlPrefix;
import io.github.easyretrofit.extension.httplog.core.annotation.RetrofitHttpLog;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.concurrent.CompletableFuture;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */

// use @RetrofitUrlPrefix
@RetrofitBuilder(baseUrl = "${app.url.host}")
//@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
@RetrofitHttpLog(level = HttpLoggingInterceptor.Level.BODY, extensions = @RetrofitInterceptorParam(type = InterceptorType.NETWORK))
@RetrofitPath("${app.url.prefix}")
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    HelloBean hello(@Path("message") String message);

    @GET("hello/error/{message}")
    HelloBean hello5(@Path("message") String message);

    @GET("hello/{message}")
    ListenableFuture<HelloBean> hello2(@Path("message") String message);

    @GET("hello/{message}")
    CompletableFuture<HelloBean> hello3(@Path("message") String message);

    @GET("hello")
    String hello4(@Path("message") String message);

}
