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
        helloBean.setMessage(message);
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v2/hello/{message}")
    public ResponseEntity<HelloBean> helloPath2(@PathVariable String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v1/hello")
    public ResponseEntity<HelloBean> helloParam() {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage("hello" + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @PostMapping("/v1/hello")
    public ResponseEntity<HelloBean> helloBody(@RequestBody HelloBean helloBean) {
        helloBean.setMessage(helloBean.getMessage() + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v1/hello/int")
    public ResponseEntity<Integer> helloIntBody() {
        return ResponseEntity.ok(new Random().nextInt());
    }

    @GetMapping("/v1/error/400")
    public ResponseEntity<HelloBean> helloError400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/v1/error/404")
    public ResponseEntity<HelloBean> helloError404() {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/v1/error/timeout")
    public ResponseEntity<HelloBean> helloErrorTimeout() {
        try {
            Thread.sleep(1000 * 6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage("backend");
        return ResponseEntity.ok(helloBean);
    }

}
