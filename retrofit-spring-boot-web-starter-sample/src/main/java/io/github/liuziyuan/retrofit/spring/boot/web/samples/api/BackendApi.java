package io.github.liuziyuan.retrofit.spring.boot.web.samples.api;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.easyretrofit.core.annotation.RetrofitPath;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.ApiResponse2;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.error.ErrorResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.concurrent.CompletableFuture;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */

// use @RetrofitUrlPrefix
@RetrofitBuilder(baseUrl = "http://localhost:9100")
//@RetrofitInterceptor(handler = LoggingInterceptor.class, type = InterceptorType.NETWORK)
@RetrofitPath("/backend")
public interface BackendApi {

    @ErrorResponseBody(codeFieldName = "code", codeType = String.class, messageFieldName = "message", messageType = String.class)
    @GET("v1/api/response")
    ApiResponse2<HelloBean> helloApiResponse();

    @ErrorResponseBody(codeFieldName = "code", codeType = String.class, messageFieldName = "message", messageType = String.class, messageWrapper = "from backend: {}")
    @GET("v1/api/response/failure")
    ApiResponse2<HelloBean> helloApiResponseFailure();
}
