package io.github.liuziyuan.retrofit.spring.cloud.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Slf4j
@Controller
public class HelloController {
    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws InterruptedException {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt() + "/v1");
        return ResponseEntity.ok(helloBean);
    }
}
