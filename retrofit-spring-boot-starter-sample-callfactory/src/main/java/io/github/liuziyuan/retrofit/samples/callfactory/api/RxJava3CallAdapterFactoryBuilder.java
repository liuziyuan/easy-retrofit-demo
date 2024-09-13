package io.github.liuziyuan.retrofit.samples.callfactory.api;


import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

/**
 * @author liuziyuan
 */
public class RxJava3CallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return RxJava3CallAdapterFactory.create();
    }
}
