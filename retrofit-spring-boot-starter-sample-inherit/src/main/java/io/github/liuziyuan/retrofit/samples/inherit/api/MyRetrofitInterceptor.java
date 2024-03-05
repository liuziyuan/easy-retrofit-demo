package io.github.liuziyuan.retrofit.samples.inherit.api;

import io.github.liuziyuan.retrofit.core.RetrofitResourceContext;
import io.github.liuziyuan.retrofit.core.extension.BaseInterceptor;
import io.github.liuziyuan.retrofit.core.resource.RetrofitApiServiceBean;
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

    @Autowired
    private RetrofitResourceContext context;

    @SneakyThrows
    @Override
    protected Response executeIntercept(Chain chain) {
        Request request = chain.request();
        String clazzName = Objects.requireNonNull(request.tag(Invocation.class)).method().getDeclaringClass().getName();
        final RetrofitApiServiceBean currentServiceBean = context.getRetrofitApiServiceBean(clazzName);
        // TODO if you need
        return chain.proceed(request);
    }
}
