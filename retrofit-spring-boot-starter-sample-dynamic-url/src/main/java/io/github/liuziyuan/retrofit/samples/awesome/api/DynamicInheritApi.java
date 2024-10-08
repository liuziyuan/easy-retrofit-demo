package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.easyretrofit.core.annotation.RetrofitDynamicBaseUrl;
import io.github.easyretrofit.core.annotation.RetrofitPath;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
@RetrofitDynamicBaseUrl("${app.url.host-dynamic}")
@RetrofitPath("${app.url.prefix}")
public interface DynamicInheritApi extends DynamicBaseApi {

    @GET("hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);
}
