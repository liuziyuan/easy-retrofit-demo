package io.github.liuziyuan.retrofit.spring.loadbalancer.reactor.service;

import io.github.easyretrofit.adapter.reactor.ReactorCallAdapterFactory;
import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;

public class ReactorAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return ReactorCallAdapterFactory.create();
    }
}
