package io.github.liuziyuan.retrofit.samples.inherit.controller;

import io.github.liuziyuan.retrofit.samples.inherit.domain.HelloBean;
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

}
