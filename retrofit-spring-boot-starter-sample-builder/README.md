# retrofit-spring-boot-starter-samples-builder

## How to run
1. Start backend service project
2. Start current project
3. run `curl` command on terminal

``` shell
curl http://localhost:9102/v1/hello/abc 
```

## How to use

Inherit `BaseCallAdapterFactoryBuilder` to build a Retrofit `CallAdapter.Factory`

Inherit `BaseConverterFactoryBuilder` to build a Retrofit `Converter.Factory`

Inherit `BaseCallFactoryBuilder` to build a Retrofit `Call.Factory`

Inherit `BaseCallBackExecutorBuilder` to build a Retrofit `CallBackExecutor`

Inherit `BaseOkHttpClientBuilder` to build a Retrofit `OkHttpClient.Builder`

Inherit `BaseInterceptor` to intercept a OkHttpClient `Interceptor`


Backend Services API Responses JSON object , a `converter` that can parse JSON.

```xml

<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>converter-gson</artifactId>
    <version>2.9.0</version>
</dependency>
```

If any builder or interceptor needs to inject spring managed objects, it needs to add @ component and @ Autowired

```java

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
        final RetrofitServiceBean currentServiceBean = context.getRetrofitServiceBean(clazzName);
        // TODO if you need
        return chain.proceed(request);
    }
}
```

In general, refer to the following, It doesn't need to be managed by spring container

```java
public class GsonConvertFactoryBuilder extends BaseConverterFactoryBuilder {
    @Override
    public Converter.Factory buildConverterFactory() {
        return GsonConverterFactory.create();
    }
}

```
