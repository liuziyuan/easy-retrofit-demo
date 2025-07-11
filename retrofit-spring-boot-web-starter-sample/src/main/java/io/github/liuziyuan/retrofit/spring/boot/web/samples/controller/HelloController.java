package io.github.liuziyuan.retrofit.spring.boot.web.samples.controller;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.ApiResponse2;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.api.BackendApi;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.api.HelloApi;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liuziyuan
 */
//@Api(tags = "Hello Api")
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;

    @Autowired
    private BackendApi backendApi;

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

    @GetMapping("/v3/hello/{message}")
    public ResponseEntity<HelloBean> hello3(@PathVariable String message) throws IOException, ExecutionException, InterruptedException {
        CompletableFuture<HelloBean> completableFuture = helloApi.hello3(message);
        HelloBean helloBean = completableFuture.get();
        return ResponseEntity.ok(helloBean);
    }

    @GetMapping("/v4/hello/{message}")
    public ResponseEntity<String> hello4(@PathVariable String message) throws IOException {
        String string = helloApi.hello4(message);
        return ResponseEntity.ok(string);
    }

    @GetMapping("/v5/hello/{message}")
    public ResponseEntity<HelloBean> helloError(@PathVariable String message) throws IOException {
        HelloBean hello = helloApi.hello5(message);
        return ResponseEntity.ok(hello);
    }

    @GetMapping("/v1/api/response")
    public ApiResponse2<HelloBean> helloApiResponse() {
        return backendApi.helloApiResponse();
    }

    @GetMapping("/v1/api/response/failure")
    public ApiResponse2<HelloBean> helloApiResponseFailure() {
        return backendApi.helloApiResponseFailure();
    }

}
