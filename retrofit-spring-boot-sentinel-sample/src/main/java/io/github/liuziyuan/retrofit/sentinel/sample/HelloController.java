package io.github.liuziyuan.retrofit.sentinel.sample;

import io.github.liuziyuan.retrofit.sentinel.sample.sentinel.RetrofitSentinelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    @Autowired
    private RetrofitSentinelApi retrofitSentinelApi;


    @GetMapping("/v1/hello/{message}")
    public ApiResponse<HelloBean> helloSentinelDegrade(@PathVariable String message) throws IOException {
        ApiResponse<HelloBean> hello = retrofitSentinelApi.helloDegrade(message);
        return hello;
    }

    @GetMapping("/v2/hello/{message}")
    public ApiResponse<HelloBean> helloSentinelFlow(@PathVariable String message) throws IOException {
        ApiResponse<HelloBean> hello = retrofitSentinelApi.helloFlow(message);
        return hello;
    }

    @GetMapping("/v3/hello/{message}")
    public ApiResponse<HelloBean> helloNoSentinel(@PathVariable String message) throws IOException {
        ApiResponse<HelloBean> hello = retrofitSentinelApi.helloNoSentinel(message);
        return hello;
    }


}
