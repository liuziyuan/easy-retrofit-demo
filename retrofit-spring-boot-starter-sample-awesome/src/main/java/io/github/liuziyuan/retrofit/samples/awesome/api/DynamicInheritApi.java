package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.liuziyuan.retrofit.annotation.RetrofitDynamicBaseUrl;
import io.github.liuziyuan.retrofit.annotation.RetrofitUrlPrefix;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
@RetrofitDynamicBaseUrl("${app.url.host2}")
@RetrofitUrlPrefix("${app.url.prefix}")
public interface DynamicInheritApi extends DynamicBaseApi {

    @GET("hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);
}
