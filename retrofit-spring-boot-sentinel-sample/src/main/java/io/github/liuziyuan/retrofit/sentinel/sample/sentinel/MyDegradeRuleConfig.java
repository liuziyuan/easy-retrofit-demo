package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import io.github.liuziyuan.retrofit.extension.sentinel.core.resource.BaseDegradeRuleConfig;
import io.github.liuziyuan.retrofit.extension.sentinel.core.resource.CustomizeDegradeRuleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDegradeRuleConfig extends BaseDegradeRuleConfig {
    @Override
    protected CustomizeDegradeRuleBean generate() {
        //设置熔断触发的最小请求数(count)为 1 设置熔断触发的时间窗口(timeWindow)为 20s 设置熔断触发的降级比例阈值(slowRatioThreshold)为 100%
        CustomizeDegradeRuleBean customizeDegradeRuleBean = new CustomizeDegradeRuleBean();
        customizeDegradeRuleBean.setCount(1);
        customizeDegradeRuleBean.setTimeWindow(20);
        customizeDegradeRuleBean.setSlowRatioThreshold(1.0);
        customizeDegradeRuleBean.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        return customizeDegradeRuleBean;
    }
}
