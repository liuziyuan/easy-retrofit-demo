package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import io.github.liuziyuan.retrofit.extension.sentinel.core.BaseFallBack;
import io.github.liuziyuan.retrofit.extension.sentinel.core.interceptor.SentinelBlockException;
import lombok.extern.slf4j.Slf4j;
import io.github.liuziyuan.retrofit.sentinel.sample.ApiResponse;
import io.github.liuziyuan.retrofit.sentinel.sample.HelloBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetrofitSentinelApiFallBack extends BaseFallBack<SentinelBlockException> {

    private SentinelBlockException exception;

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
    protected void getFallBackException(SentinelBlockException e) {
        this.exception = e;
    }
}
