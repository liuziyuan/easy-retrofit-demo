package io.github.liuziyuan.retrofit.spring.boot.web.samples.controller;

import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author liuziyuan
 */
@RestController
@RequestMapping("/backend/v1/hello")
public class BackendController {
    @GetMapping("/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/error/{message}")
    public ResponseEntity<HelloBean> helloError(@PathVariable String message) {
        throw new RuntimeException("error");
    }

    @GetMapping("")
    public ResponseEntity<String> hello2(@PathVariable String message) {
        return ResponseEntity.ok(message);
    }
}
