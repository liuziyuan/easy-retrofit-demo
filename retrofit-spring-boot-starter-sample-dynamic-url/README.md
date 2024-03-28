#Retrofit-spring-boot-starter-samples-url-prefix

## How to run
1. Start backend service
2. Start current project
3. run `curl` command on terminal

``` shell
curl http://localhost:9107/v1/hello/abc 
```
### @RetrofitDynamicBaseUrl Annotation

You can use `@RetrofitDynamicBaseUrl` to dynamically change the `baseUrl` in `@RetrofitBuilder`


