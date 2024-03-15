package io.github.liuziyuan.retrofit.samples.retrofitbuilder.controller;

import io.github.liuziyuan.retrofit.samples.retrofitbuilder.api.HelloApi;
import io.github.liuziyuan.retrofit.samples.retrofitbuilder.domain.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws IOException {
        final HelloBean body = helloApi.hello(message).execute().body();
        return ResponseEntity.ok(body);
    }
}
