package io.github.liuziyuan.retrofit.samples.awesome.api;

import io.github.easyretrofit.core.annotation.RetrofitDynamicBaseUrl;
import io.github.easyretrofit.core.annotation.RetrofitInterceptor;
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
@RetrofitInterceptor(handler = MyRetrofitInterceptor1.class)
public interface DynamicInheritApi2 extends DynamicInheritApi {

    @GET("hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);
}
