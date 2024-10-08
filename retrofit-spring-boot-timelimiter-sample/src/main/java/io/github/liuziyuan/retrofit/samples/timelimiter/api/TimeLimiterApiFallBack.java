package io.github.liuziyuan.retrofit.samples.timelimiter.api;

import io.github.easyretrofit.core.exception.RetrofitExtensionException;
import io.github.easyretrofit.core.delegate.BaseFallBack;
import io.github.liuziyuan.retrofit.samples.timelimiter.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TimeLimiterApiFallBack extends BaseFallBack<RetrofitExtensionException> implements HelloApi {

    private RetrofitExtensionException exception;

    @Override
    protected void setFallBackException(RetrofitExtensionException exception) {
        this.exception = exception;
    }

    @Override
    public HelloBean errorTimeout() {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage("errorTimeout fallback");
        log.info("errorTimeout fallback {}", exception.getMessage());
        return helloBean;
    }
}
