package io.github.liuziyuan.retrofit.samples.global.config.api;

import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * @author liuziyuan
 */
public class RxJavaCallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }
}
