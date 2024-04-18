#Retrofit-spring-boot-starter-samples-url-prefix

## How to run
1. Start backend service
2. Start current project
3. run `curl` command on terminal

``` shell
curl http://localhost:9107/v1/hello/abc 
```

this curl request will return error, because the DynamicBaseUrl is http://localhost:9200/, but you just start backend Service on port 9100.

you can debug into DynamicBaseUrlInterceptor file, you will see the `realDynamicHostUrl` is `http://localhost:9200/`

### @RetrofitDynamicBaseUrl Annotation

You can use `@RetrofitDynamicBaseUrl` to dynamically change the `baseUrl` in `@RetrofitBuilder`




