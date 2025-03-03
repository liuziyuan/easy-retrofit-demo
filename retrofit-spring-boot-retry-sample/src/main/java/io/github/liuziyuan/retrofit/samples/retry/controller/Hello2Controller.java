package io.github.liuziyuan.retrofit.samples.retry.controller;

//import io.github.easyretrofit.core.exception.RetrofitExtensionException;

import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import io.github.liuziyuan.retrofit.samples.retry.api.HelloApi;
import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
public class Hello2Controller {

    @Autowired
    private HelloApi helloApi;
    @Autowired
    private View error;

    @GetMapping("/v5/hello")
    public HelloBean getHelloBean() {
        return helloApi.hello();
    }

    @GetMapping("/v5/hello/error")
    public HelloBean getHelloBeanError() {
        return helloApi.error400();
    }


    @GetMapping("/v2/hello/{message}")
    public Mono<HelloBean> hello(@PathVariable String message) throws IOException {
        return Mono.fromCallable(helloApi::error400);
    }

    @GetMapping("/v3/hello/{message}")
    public Mono<HelloBean> helloMono400(@PathVariable String message) throws IOException {
        return helloApi.helloMono400().onErrorResume(error -> {
            log.info("error400 fallback {}", error.getMessage());
            HelloBean helloBean = new HelloBean();
            helloBean.setMessage("mono error400 fallback");
            return Mono.just(helloBean);
        });
    }


    @GetMapping("/v4/hello/{message}")
    public Mono<HelloBean> helloFlowable400(@PathVariable String message) throws IOException {

        Flowable<HelloBean> helloBeanFlowable = helloApi.helloFlowable400();
        return helloBeanFlowable.to(Mono::from).onErrorResume(error -> {
            log.info("error400 fallback {}", error.getMessage());
            HelloBean helloBean = new HelloBean();
            helloBean.setMessage("mono error400 fallback");
            return Mono.just(helloBean);
        });
    }
}
