#Retrofit-spring-boot-starter-samples-inherit

Swagger-UI URL: http://localhost:9092/swagger-ui/index.html

### If you have hundreds of APIs and these APIs have the same HostURL, you certainly don't want to put all APIs in the same Interface file, so you can create a BaseAPI Interface to create a retrofit instance, and other interface files inherit the BaseAPI.

### In this way, your code will be more structured and readable

### BaseAPI
```java
@RetrofitBuilder(baseUrl = "${app.hello.url}",
        addConverterFactory = {GsonConvertFactoryBuilder.class},
        client = OkHttpClientBuilder.class)
@RetrofitInterceptor(handler = LoggingInterceptor.class)
@RetrofitInterceptor(handler = MyRetrofitInterceptor.class)
public interface BaseApi {
}

```

### Inherited API
```java
public interface HelloApi extends BaseApi {
    /**
     * call hello API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("v1/hello/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}

```

```java
public interface TestApi extends BaseApi {

    /**
     * call test API method of backend service
     *
     * @param message message
     * @return
     */
    @GET("v1/test/{message}")
    Call<HelloBean> hello(@Path("message") String message);
}
```

### Call API in Controller
```java
@Slf4j
@Api(tags = "Hello Api")
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @Autowired
    private HelloApi helloApi;
    @Autowired
    private TestApi testApi;

    @GetMapping("/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final HelloBean helloBody = helloApi.hello(message).execute().body();
        final HelloBean testBody = testApi.hello(message).execute().body();
        return ResponseEntity.ok(helloBody.getMessage() + " - " + testBody.getMessage());
    }
}
```

###* You can set `@RetrofitInterceptor` in any interface that inherits the parent interface, form v0.0.11

### if you used multiple inheritance, The first Interface will take effect in the extends list, please don't use multiple inheritance



