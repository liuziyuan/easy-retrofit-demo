package io.github.liuziyuan.retrofit.samples.inherit.api;

import io.github.liuziyuan.retrofit.samples.inherit.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
public interface TestApi extends MiddleApi, OtherApi {

    /**
     * call test API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("backend/v1/hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
