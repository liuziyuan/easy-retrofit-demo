package io.github.liuziyuan.retrofit.samples.builder.api;


import io.github.easyretrofit.adapter.simplebody.SimpleBodyCallAdapterFactory;
import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * @author liuziyuan
 */
public class SimpleBodyCallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return SimpleBodyCallAdapterFactory.create();
    }
}
