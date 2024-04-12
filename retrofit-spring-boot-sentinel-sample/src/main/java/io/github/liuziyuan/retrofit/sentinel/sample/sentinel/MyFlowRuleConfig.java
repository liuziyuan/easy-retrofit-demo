package io.github.liuziyuan.retrofit.sentinel.sample.sentinel;

import io.github.liuziyuan.retrofit.extension.sentinel.core.resource.BaseFlowRuleConfig;
import io.github.liuziyuan.retrofit.extension.sentinel.core.resource.CustomizeFlowRuleBean;

public class MyFlowRuleConfig extends BaseFlowRuleConfig {
    @Override
    protected CustomizeFlowRuleBean generate() {
        CustomizeFlowRuleBean flowRuleBean = new CustomizeFlowRuleBean();
        flowRuleBean.setCount(1);
        return flowRuleBean;
    }
}
