package io.github.liuziyuan.retrofit.samples.retrofitbuilder.controller;

import io.github.liuziyuan.retrofit.samples.retrofitbuilder.domain.HelloBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public ResponseEntity<HelloBean> postHello(@RequestBody HelloBean helloBean){
        helloBean.setMessage(helloBean.getMessage() + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

}
