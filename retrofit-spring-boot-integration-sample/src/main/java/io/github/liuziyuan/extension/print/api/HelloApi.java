package io.github.liuziyuan.extension.print.api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */
public interface HelloApi extends BaseApi{
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("backend/v1/hello/{message}")
    Call<ResponseBody> hello(@Path("message") String message);
}
