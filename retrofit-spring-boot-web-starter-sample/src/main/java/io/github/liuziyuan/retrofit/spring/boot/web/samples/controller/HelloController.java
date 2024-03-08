package io.github.liuziyuan.retrofit.spring.boot.web.samples.controller;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.api.HelloApi;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author liuziyuan
 */
@Slf4j
@Api(tags = "Hello Api")
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws IOException {
        HelloBean hello = helloApi.hello(message);
        return ResponseEntity.ok(hello);
    }

    @GetMapping("/v2/hello/{message}")
    public ResponseEntity<HelloBean> hello2(@PathVariable String message) throws IOException, ExecutionException, InterruptedException {
        ListenableFuture<HelloBean> helloBeanListenableFuture = helloApi.hello2(message);
        HelloBean helloBean = helloBeanListenableFuture.get();
        return ResponseEntity.ok(helloBean);
    }




}
