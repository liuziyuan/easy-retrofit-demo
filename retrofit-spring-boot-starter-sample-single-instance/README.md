#Retrofit-spring-boot-starter-samples-single-instance

When multiple retrofits have the same `@RetrofitBuilder` and only the prefix URLs in `baseUrl` are different, retrofit-spring-boot-starter will automatically merge multiple retrofit instances and keep only one instance. This instance will use a built-in interceptor to assemble the prefix of the URL for the baseURL

```java
@RetrofitBuilder(baseUrl = "${app.hello.v1.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        addCallAdapterFactory = {RxJavaCallAdapterFactoryBuilder.class})
@RetrofitInterceptor(handler = LoggingInterceptor.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface HelloApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
```

```java
@RetrofitBuilder(baseUrl = "${app.hello.v2.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        addCallAdapterFactory = {RxJavaCallAdapterFactoryBuilder.class})
@RetrofitInterceptor(handler = LoggingInterceptor.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface HelloApiV2 {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
```

```yaml
app:
  hello:
    v1:
      url: http://localhost:8080/v1/
    v2:
      url: http://localhost:8080/v2/
```

The `@RetrofitBuilder` and `@RetrofitInterceptor` of these two Interfaces are exactly the same, so they will be merged into one Retrofit instance

Only the prefix of the URL is different, that is, the difference between `/v1` and `v2`. In some cases, this kind of URL does appear in some back-end services.

In this example, you can find the only instance of Retrofit by injecting RetrofitResourceContext object

