package io.github.liuziyuan.retrofit.samples.callfactory.controller;

import io.github.liuziyuan.retrofit.samples.callfactory.api.HelloApi;
import io.github.liuziyuan.retrofit.samples.callfactory.domain.HelloBean;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<HelloBean> hello(@PathVariable String message) throws IOException {
        final HelloBean body = helloApi.hello(message).execute().body();
        return ResponseEntity.ok(body);
    }

    @PostMapping("")
    public ResponseEntity<HelloBean> helloPost(@RequestBody HelloBean message) throws IOException {
        Observable<HelloBean> helloBeanObservable = helloApi.helloObservable(message);
        return ResponseEntity.ok(helloBeanObservable.blockingSingle());
    }
}
