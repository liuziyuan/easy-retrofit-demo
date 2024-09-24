package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.exception.RetrofitExtensionException;
import io.github.easyretrofit.core.proxy.BaseFallBack;
import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
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
        log.info("error400 fallback {}", exception.getMessage());
        return null;
    }

    @Override
    public HelloBean error404() {
        return null;
    }
}
