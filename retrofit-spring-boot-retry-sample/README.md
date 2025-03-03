#Retrofit-spring-boot-starter-samples-inherit

## How to run
1. Start backend service
2. Start current project
3. run `curl` command on terminal

adapter is SimpleBody type, return is JOPO Bean
``` shell
curl http://localhost:9110/v1/hello/abc 
```

adapter is SimpleBody type, return Mono
``` shell
curl http://localhost:9110/v2/hello/abc
```

adapter is Reactor type, return Mono
``` shell
curl http://localhost:9110/v3/hello/abc
```

``` shell
curl http://localhost:9110/v4/hello/abc
```

所有非SimpleBody 类型的adapter, 都不会走fallback, 而是走自己的异常处理块 

