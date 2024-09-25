package io.github.liuziyuan.retrofit.samples.retry.config;

import io.github.easyretrofit.adapter.reactor.ReactorCallAdapterFactory;
import io.github.easyretrofit.core.builder.BaseCallAdapterFactoryBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import retrofit2.CallAdapter;

@Component
public class ReactorCallAdapterFactoryBuilder extends BaseCallAdapterFactoryBuilder implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public CallAdapter.Factory buildCallAdapterFactory() {

//        RetrofitExtensionFallBackHandler fallBackHandler = new RetrofitExtensionFallBackHandler(new SpringCDIBeanManager(applicationContext));
//        return ReactorCallAdapterFactory.create(fallBackHandler);
        return ReactorCallAdapterFactory.create();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
