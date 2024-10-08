package io.github.liuziyuan.retrofit.samples.inherit.api;

import io.github.easyretrofit.core.annotation.RetrofitPath;
import io.github.liuziyuan.retrofit.samples.inherit.domain.HelloBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 * <p><b>{@code ${app.hello.url}} need set in application.yml</b>
 * <p><b>Except baseUrl, other attributes are not required</b>
 *
 * @author liuziyuan
 */
@RetrofitPath("backend/v1/hello/")
public interface HelloApi extends MiddleApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
