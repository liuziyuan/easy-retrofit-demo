package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "http://localhost:8080/v1")
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
}
