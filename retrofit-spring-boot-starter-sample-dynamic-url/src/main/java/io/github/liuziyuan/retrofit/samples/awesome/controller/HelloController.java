package io.github.liuziyuan.retrofit.samples.awesome.controller;

import io.github.liuziyuan.retrofit.samples.awesome.api.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    @Qualifier("io.github.liuziyuan.retrofit.samples.awesome.api.HelloApi")
    private HelloApi helloApi;

    @Autowired
    @Qualifier("io.github.liuziyuan.retrofit.samples.awesome.api.DynamicBaseApi")
    private DynamicBaseApi dynamicBaseApi;

    @Autowired
    @Qualifier("io.github.liuziyuan.retrofit.samples.awesome.api.DynamicInheritApi")
    private DynamicInheritApi dynamicInheritApi;

    @Autowired
    private DummyDynamicInheritApi dummyDynamicInheritApi;

    @Autowired
    @Qualifier("io.github.liuziyuan.retrofit.samples.awesome.api.DynamicInheritApi2")
    private DynamicInheritApi2 dynamicInheritApi2;

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
//        return ResponseEntity.ok(body.string());
        final ResponseBody body1 = dynamicBaseApi.hello(message).execute().body();
//        return ResponseEntity.ok(body1.string());
        return ResponseEntity.ok(body.string() + "-" + body1.string());
    }

    @GetMapping("/v1/hello2/{message}")
    public ResponseEntity<String> hello2(@PathVariable String message) throws IOException
    {
        ResponseBody body = dynamicInheritApi.hello(message).execute().body();
        return ResponseEntity.ok(body.string());
    }

    @GetMapping("/v1/hello3/{message}")
    public ResponseEntity<String> hello3(@PathVariable String message) throws IOException
    {
        ResponseBody body = dynamicInheritApi2.hello(message).execute().body();
        return ResponseEntity.ok(body.string());
    }

    @GetMapping("/v1/hello4/{message}")
    public ResponseEntity<String> hello4(@PathVariable String message) throws IOException
    {
        ResponseBody body = dummyDynamicInheritApi.hello(message).execute().body();
        return ResponseEntity.ok(body.string());
    }


}
