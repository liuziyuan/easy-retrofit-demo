package io.github.liuziyuan.retrofit.spring.loadbalancer.reactor.service;


import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author liuziyuan
 */
public class RxJava2CallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return RxJava2CallAdapterFactory.createAsync();
    }
}
