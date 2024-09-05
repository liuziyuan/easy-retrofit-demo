package io.github.liuziyuan.integration.controller;


import io.github.liuziyuan.integration.api.HelloApi;
import okhttp3.ResponseBody;
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
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
        return ResponseEntity.ok(body.string());
    }
}
