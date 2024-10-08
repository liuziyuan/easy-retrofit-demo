package io.github.liuziyuan.retrofit.samples.inherit.controller;

import io.github.liuziyuan.retrofit.samples.inherit.api.BaseApi;
import io.github.liuziyuan.retrofit.samples.inherit.api.HelloApi;
import io.github.liuziyuan.retrofit.samples.inherit.api.TestApi;
import io.github.liuziyuan.retrofit.samples.inherit.domain.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("io.github.liuziyuan.retrofit.samples.inherit.api.HelloApi")
    private HelloApi helloApi;

    @Autowired
    @Qualifier("io.github.liuziyuan.retrofit.samples.inherit.api.BaseApi")
    private BaseApi baseApi;
    @Autowired
    private TestApi testApi;

    @GetMapping("/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final HelloBean helloBody = helloApi.hello(message).execute().body();
        final HelloBean testBody = testApi.hello(message).execute().body();
        return ResponseEntity.ok(helloBody.getMessage() + " - " + testBody.getMessage());
    }
}
