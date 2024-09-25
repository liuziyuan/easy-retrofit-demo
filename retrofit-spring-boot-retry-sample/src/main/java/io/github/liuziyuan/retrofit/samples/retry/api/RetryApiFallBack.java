package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.exception.RetrofitExtensionException;
import io.github.easyretrofit.core.delegate.BaseFallBack;
import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import retrofit2.Call;

@Slf4j
@Service
public class RetryApiFallBack extends BaseFallBack<RetrofitExtensionException> implements HelloApi {

    private RetrofitExtensionException exception;

    @Override
    protected void setFallBackException(RetrofitExtensionException exception) {
        this.exception = exception;
    }

    @Override
    public HelloBean error400() {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage("error400 fallback");
        log.info("error400 fallback {}", exception.getMessage());
        return helloBean;
    }

    @Override
    public HelloBean error404() {
        return null;
    }

    @Override
    public Mono<HelloBean> helloMono400() {
        log.info("error400 fallback {}", exception.getMessage());
        return Mono.just(new HelloBean());
    }
}
