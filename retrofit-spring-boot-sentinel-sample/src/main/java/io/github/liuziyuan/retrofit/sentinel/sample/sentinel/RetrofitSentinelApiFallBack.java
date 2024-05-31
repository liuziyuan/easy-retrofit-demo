package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import io.github.liuziyuan.retrofit.core.exception.RetrofitExtensionException;
import io.github.liuziyuan.retrofit.core.proxy.BaseFallBack;
import lombok.extern.slf4j.Slf4j;
import io.github.liuziyuan.retrofit.sentinel.sample.ApiResponse;
import io.github.liuziyuan.retrofit.sentinel.sample.HelloBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetrofitSentinelApiFallBack extends BaseFallBack<RetrofitExtensionException> {

    private RetrofitExtensionException exception;

    public ApiResponse<HelloBean> helloDegrade(String message) {
        log.info("invoke si method params:  {}", message);

        return ApiResponse.error(503, exception.getMessage());
    }

    public ApiResponse<HelloBean> helloFlow(String message) {

        return ApiResponse.error(503, exception.getMessage());
    }

    public ApiResponse<HelloBean> helloNoSentinel(String message) {

        return null;
    }

    @Override
    protected void setFallBackException(RetrofitExtensionException e) {
        this.exception = e;
    }
}
