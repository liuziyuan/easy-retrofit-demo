package io.github.liuziyuan.retrofit.samples.singleinstance.api;

import io.github.liuziyuan.retrofit.samples.singleinstance.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
public interface TestApi extends BaseApi {

    /**
     * call test API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("v1/test/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
