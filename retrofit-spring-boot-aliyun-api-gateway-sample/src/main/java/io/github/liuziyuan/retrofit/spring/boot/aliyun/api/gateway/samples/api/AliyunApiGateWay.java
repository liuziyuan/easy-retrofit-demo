package io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples.api;

import io.github.liuziyuan.retrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.extension.aliyun.api.gateway.core.RetrofitAliyunApiGateway;
import io.github.liuziyuan.retrofit.spring.boot.aliyun.api.gateway.samples.*;

@RetrofitBuilder(addConverterFactory = JacksonConvertFactoryBuilder.class,
        addCallAdapterFactory = {BodyCallAdapterFactoryBuilder.class, GuavaCallAdapterFactoryBuilder.class, RxJava3CallAdapterFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitAliyunApiGateway
public interface AliyunApiGateWay {
}
