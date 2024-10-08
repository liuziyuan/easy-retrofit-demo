package io.github.liuziyuan.retrofit.samples.retry.controller;

import io.github.liuziyuan.retrofit.samples.retry.HelloBean;
import io.github.liuziyuan.retrofit.samples.retry.api.HelloApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;

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
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        HelloBean helloBean = helloApi.error400();
        return ResponseEntity.ok(helloBean.getMessage());
    }
}
