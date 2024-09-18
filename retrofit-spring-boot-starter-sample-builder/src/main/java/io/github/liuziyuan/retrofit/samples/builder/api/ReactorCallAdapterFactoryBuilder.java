package io.github.liuziyuan.retrofit.samples.builder.api;

import io.github.easyretrofit.adapter.reactor.ReactorCallAdapterFactory;
import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import retrofit2.CallAdapter;

public class ReactorCallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder {
    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {
        return ReactorCallAdapterFactory.create();
    }
}
