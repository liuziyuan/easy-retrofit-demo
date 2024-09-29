package io.github.liuziyuan.retrofit.samples.timelimiter.controller;

import io.github.liuziyuan.retrofit.samples.timelimiter.HelloBean;
import io.github.liuziyuan.retrofit.samples.timelimiter.api.HelloApi;
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
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        HelloBean helloBean = helloApi.errorTimeout();
        return ResponseEntity.ok(helloBean.getMessage());
    }
}
