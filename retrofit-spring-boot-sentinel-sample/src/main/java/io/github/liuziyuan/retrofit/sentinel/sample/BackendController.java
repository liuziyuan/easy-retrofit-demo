package io.github.liuziyuan.retrofit.sentinel.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author liuziyuan
 */
@Slf4j
@RestController
@RequestMapping("/backend")
public class BackendController {
    @GetMapping("/error/{message}")
    public ApiResponse<HelloBean> hello(@PathVariable String message) throws Exception {
        log.info("backend hello message:{}", message);
        throw new RuntimeException();
    }


    @GetMapping("/right/{message}")
    public ApiResponse<HelloBean> hello2(@PathVariable String message) throws Exception {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ApiResponse.success(helloBean);
    }
}
