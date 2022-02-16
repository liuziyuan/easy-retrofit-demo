package api;

import domain.HelloBean;
import io.github.liuziyuan.retrofit.annotation.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 * <p><b>{@code ${app.hello.url}} need set in application.yml</b>
 * @author liuziyuan
 */
@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConverterFactory.class},
        addCallAdapterFactory = {})
public interface HelloApi {
    /**
     * call hello API method of backend service
     * @param message message
     * @return
     */
    @GET("v1/hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
