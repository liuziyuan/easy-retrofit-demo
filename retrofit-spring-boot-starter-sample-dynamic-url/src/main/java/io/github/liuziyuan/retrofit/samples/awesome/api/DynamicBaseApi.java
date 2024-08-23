package io.github.liuziyuan.retrofit.samples.awesome.api;


import io.github.easyretrofit.core.annotation.InterceptorType;
import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitInterceptor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.url.host}")
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
public interface DynamicBaseApi {

    @GET("backend/v1/hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);

}
