package io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples;

import io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples.api.TestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestApi testApi;

    @GetMapping("/test")
    public String test() {
        return testApi.hello().getName();
    }
}
