package io.github.liuziyuan.retrofit.spring.loadbalancer.reactor.service;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/reactor1/{message}")
    public Mono<HelloBean> hello(@PathVariable String message) throws InterruptedException {
        return helloApi.hello(message);
    }

    @GetMapping("/reactor2/{message}")
    public Mono<HelloBean> hello2(@PathVariable String message) throws InterruptedException {
        Observable<HelloBean> helloBeanObservable = helloApi.hello2(message);
        return Mono.from(helloBeanObservable.toFlowable(BackpressureStrategy.BUFFER));
    }

}
