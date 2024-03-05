package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.liuziyuan.retrofit.core.annotation.InterceptorType;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitInterceptor;
import io.github.liuziyuan.retrofit.core.annotation.RetrofitUrlPrefix;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */

// use @RetrofitUrlPrefix
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
@RetrofitUrlPrefix("${app.url.prefix}")
//@RetrofitBuilder(baseUrl = "http://localhost:8080/v1/")
//@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);

    @GET("/hello/{message}")
    Call<ResponseBody> hello2(@Path("message") String message);

    @GET("http://www.github.com/robots.txt")
    Call<ResponseBody> robots();

    @HTTP(method = "GET", path = "hello/{message}")
    Call<ResponseBody> httpHello(@Path("message") String message);

    @HTTP(method = "GET", path = "/hello/{message}")
    Call<ResponseBody> httpHello2(@Path("message") String message);

    @HTTP(method = "GET", path = "http://www.github.com/robots.txt")
    Call<ResponseBody> httpRobots();

}
