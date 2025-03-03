package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.core.exception.RetrofitRuntimeException;
import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryApiFallBack {

    public HelloBean hello() {
        return null;
    }

    public HelloBean error400(RetrofitRuntimeException exception) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage("error400 fallback");
        log.info("error400 fallback {}", exception.getMessage());
        return helloBean;
    }

}
