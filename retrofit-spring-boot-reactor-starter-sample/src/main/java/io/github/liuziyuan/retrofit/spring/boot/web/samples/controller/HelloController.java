package io.github.liuziyuan.retrofit.spring.boot.web.samples.controller;

import io.github.liuziyuan.retrofit.spring.boot.web.samples.api.HelloApi;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/v1/hello/{message}")
    public Mono<HelloBean> hello(@PathVariable String message) throws IOException {
        return helloApi.hello(message);
    }

    @GetMapping("/v2/hello/{message}")
    public Mono<HelloBean> hello2(@PathVariable String message) throws IOException {
        Observable<HelloBean> observable = helloApi.hello2(message);
        return Mono.from(observable.toFlowable(BackpressureStrategy.BUFFER));
    }

}
