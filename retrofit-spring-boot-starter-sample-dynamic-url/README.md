#Retrofit-spring-boot-starter-samples-url-prefix

## How to run
1. Start backend service
2. Start current project
3. run `curl` command on terminal

this request into MyRetrofitInterceptor, MyRetrofitInterceptor1 and LoggingInterceptor, return success response
``` shell
curl http://localhost:9107/v1/hello/abc 
```

this request just into MyRetrofitInterceptor, return error response
``` shell
curl http://localhost:9107/v1/hello2/abc 
```

this request into MyRetrofitInterceptor and MyRetrofitInterceptor1, return error response
``` shell
curl http://localhost:9107/v1/hello3/abc 
```

this request goto backend service, return success response
``` shell
curl http://localhost:9107/v1/hello4/abc 
```

this curl request will return error, because the DynamicBaseUrl is http://localhost:9200/, but you just start backend Service on port 9100.

you can debug into DynamicBaseUrlInterceptor file, you will see the `realDynamicHostUrl` is `http://localhost:9200/`

### @RetrofitDynamicBaseUrl Annotation

You can use `@RetrofitDynamicBaseUrl` to dynamically change the `baseUrl` in `@RetrofitBuilder`




