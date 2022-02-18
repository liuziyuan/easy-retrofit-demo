package io.github.liuziyuan.retrofit.samples.singleinstance.controller;

import io.github.liuziyuan.retrofit.samples.singleinstance.api.HelloApi;
import io.github.liuziyuan.retrofit.samples.singleinstance.api.TestApi;
import io.github.liuziyuan.retrofit.samples.singleinstance.domain.HelloBean;
import io.swagger.annotations.Api;
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
@Api(tags = "Hello Api")
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @Autowired
    private HelloApi helloApi;
    @Autowired
    private TestApi testApi;

    @GetMapping("/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final HelloBean helloBody = helloApi.hello(message).execute().body();
        final HelloBean testBody = testApi.hello(message).execute().body();
        return ResponseEntity.ok(helloBody.getMessage() + " - " + testBody.getMessage());
    }
}
