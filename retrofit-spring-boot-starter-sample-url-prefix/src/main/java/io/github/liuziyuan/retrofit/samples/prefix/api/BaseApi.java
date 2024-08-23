package io.github.liuziyuan.retrofit.samples.prefix.api;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitPath;
import io.github.liuziyuan.retrofit.samples.prefix.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author liuziyuan
 */

@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitPath("backend/v1/hello/")
public interface BaseApi {

    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
