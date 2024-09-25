package io.github.liuziyuan.retrofit.samples.retry.controller;

import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import io.github.liuziyuan.retrofit.samples.retry.api.HelloApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
@RequestMapping("/v2/hello")
public class Hello2Controller {

    @Autowired
    private HelloApi helloApi;


    @GetMapping("/{message}")
    public Mono<HelloBean> hello(@PathVariable String message) throws IOException {
        return Mono.fromCallable(helloApi::error400);
    }
}
