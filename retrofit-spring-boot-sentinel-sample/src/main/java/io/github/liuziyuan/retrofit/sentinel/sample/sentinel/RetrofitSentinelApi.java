package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import io.github.liuziyuan.retrofit.extension.sentinel.core.annotation.RetrofitSentinelDegradeRule;
import io.github.liuziyuan.retrofit.extension.sentinel.core.annotation.RetrofitSentinelFlowRule;
import io.github.liuziyuan.retrofit.sentinel.sample.HelloBean;
import io.github.liuziyuan.retrofit.sentinel.sample.ApiResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;


public interface RetrofitSentinelApi extends BaseApi {

    // 设置熔断触发的最小请求数(count)为 1 设置熔断触发的时间窗口(timeWindow)为 20s 设置熔断触发的降级比例阈值(slowRatioThreshold)为 100%
    @RetrofitSentinelDegradeRule(resourceName = "helloDegrade", fallbackMethod = "helloDegrade")
    @GET("backend/error/{message}")
    ApiResponse<HelloBean> helloDegrade(@Path("message") String message);

    @RetrofitSentinelFlowRule(config = MyFlowRuleConfig.class, fallbackMethod = "helloFlow")
    @GET("backend/right/{message}")
    ApiResponse<HelloBean> helloFlow(@Path("message") String message);

    @GET("backend/right/{message}")
    ApiResponse<HelloBean> helloNoSentinel(@Path("message") String message);

}
