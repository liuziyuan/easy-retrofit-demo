package io.github.liuziyuan.retrofit.samples.backendservices.controller;

import io.github.liuziyuan.retrofit.samples.backendservices.domain.HelloBean;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author liuziyuan
 */
@Slf4j
@Api(tags = "Hello Api")
@RestController
public class HelloController {

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws InterruptedException {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt() + "/v1");
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/hello/{message}")
    public ResponseEntity<HelloBean> hello2(@PathVariable String message) throws InterruptedException {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt() + "/");
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v1/hello2")
    public ResponseEntity<List<HelloBean>> hello3() throws InterruptedException {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(new Random().nextInt() + "/");
        HelloBean helloBean2 = new HelloBean();
        helloBean2.setMessage(new Random().nextInt() + "/");
        List<HelloBean> list = new ArrayList<>();
        list.add(helloBean);
        list.add(helloBean2);
        return ResponseEntity.ok(list);
    }
}
