package io.github.liuziyuan.retrofit.samples.retry.api;

import io.github.easyretrofit.extension.retry.core.resource.BaseRetryConfig;
import io.github.easyretrofit.extension.retry.core.resource.CustomizedRetryConfig;

import java.util.Optional;

public class HelloRetryConfig extends BaseRetryConfig {
    @Override
    protected CustomizedRetryConfig customizeRetryConfig() {
        CustomizedRetryConfig customizedRetryConfig = new CustomizedRetryConfig();
        customizedRetryConfig.setMaxRetries(Optional.of(2));
        return customizedRetryConfig;
    }
}
