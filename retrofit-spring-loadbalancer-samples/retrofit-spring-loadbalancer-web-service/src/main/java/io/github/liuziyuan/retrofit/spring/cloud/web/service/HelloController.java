package io.github.liuziyuan.retrofit.spring.cloud.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/web/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws InterruptedException {
        HelloBean helloBean = helloApi.hello(message);
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/web2/{message}")
    public ResponseEntity<HelloBean> hello3(@PathVariable String message) throws InterruptedException, IOException {
        Response<HelloBean> execute = helloApi.hello3(message).execute();
        HelloBean body = execute.body();
        return  ResponseEntity.ok(body);
    }
}
