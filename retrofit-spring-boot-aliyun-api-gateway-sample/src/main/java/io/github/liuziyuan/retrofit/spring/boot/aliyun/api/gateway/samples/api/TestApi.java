package io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples.api;

import io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.api.AliyunApiGateWay;
import retrofit2.http.GET;

public interface TestApi extends AliyunApiGateWay {

    @GET("/hello")
    HelloBean hello();
}