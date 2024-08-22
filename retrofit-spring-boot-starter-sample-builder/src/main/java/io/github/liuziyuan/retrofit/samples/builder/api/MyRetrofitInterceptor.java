package io.github.liuziyuan.retrofit.samples.builder.api;

import io.github.easyretrofit.core.RetrofitResourceContext;
import io.github.easyretrofit.core.extension.BaseInterceptor;
import io.github.easyretrofit.core.resource.RetrofitApiInterfaceBean;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Invocation;

import java.util.Objects;

/**
 *
 * @author liuziyuan
 * @date 1/5/2022 5:44 PM
 */
@Slf4j
@Component
public class MyRetrofitInterceptor extends BaseInterceptor {

    /**
     * The context is created and registered in the spring container by retrofit-spring-boot-starter. The context object includes all retrofit-spring-boot-starter context objects
     */
    @Autowired
    private RetrofitResourceContext context;

    @SneakyThrows
    @Override
    protected Response executeIntercept(Chain chain) {
        Request request = chain.request();
        String clazzName = Objects.requireNonNull(request.tag(Invocation.class)).method().getDeclaringClass().getName();
        final RetrofitApiInterfaceBean currentServiceBean = context.getRetrofitApiInterfaceBean(clazzName);
        // TODO if you need
        return chain.proceed(request);
    }
}
