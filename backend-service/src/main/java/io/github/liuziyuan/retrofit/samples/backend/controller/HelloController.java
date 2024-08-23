package io.github.liuziyuan.retrofit.samples.backend.controller;

import io.github.liuziyuan.retrofit.samples.backend.domain.HelloBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/backend")
public class HelloController {

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<HelloBean> helloPath(@PathVariable String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v2/hello/{message}")
    public ResponseEntity<HelloBean> helloPath2(@PathVariable String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v1/hello")
    public ResponseEntity<HelloBean> helloParam(@RequestParam String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @PostMapping("/v1/hello")
    public ResponseEntity<HelloBean> helloBody(@RequestBody HelloBean helloBean) {
        helloBean.setMessage(helloBean.getMessage() + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

}
