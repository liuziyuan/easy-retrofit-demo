package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.extension.retry.core.annotation.EnableRetry;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

@EnableRetry(extensions = @RetrofitInterceptorParam(sort = 10))
@RetrofitBuilder(baseUrl = "${app.hello.url}")
public interface HelloApi {

    @GET("backend/v1/error/400")
    Call<ResponseBody> error400();
}
