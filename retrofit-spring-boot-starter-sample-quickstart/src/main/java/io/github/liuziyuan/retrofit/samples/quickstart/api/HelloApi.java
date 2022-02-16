package io.github.liuziyuan.retrofit.samples.quickstart.api;

import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.samples.quickstart.domain.HelloBean;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "http://localhost:8080", addConverterFactory = {GsonConverterFactory.class})
public interface HelloApi {
    /**
     * call hello API method of backend service
     * @param message message
     * @return
     */
    @GET("/v1/hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
