package io.github.liuziyuan.retrofit.samples.global.config.controller;

import io.github.liuziyuan.retrofit.samples.global.config.api.HelloApi;
import io.github.liuziyuan.retrofit.samples.global.config.domain.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;


    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final HelloBean body = helloApi.hello(message).execute().body();
        return ResponseEntity.ok(message + "-" + body.getMessage());
    }


}
