package io.github.liuziyuan.retrofit.samples.awesome.controller;

import io.github.liuziyuan.retrofit.samples.awesome.api.DynamicInheritApi;
import io.github.liuziyuan.retrofit.samples.awesome.api.HelloApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
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
    @Autowired
    private DynamicInheritApi dynamicInheritApi;

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
        final ResponseBody body1 = dynamicInheritApi.hello(message).execute().body();
        return ResponseEntity.ok(body.string() + "-" + body1.string());
    }


}
