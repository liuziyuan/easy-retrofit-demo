# retrofit spring boot Reactor starter samples
The request of HelloController will call itself BackendController

## how to test

1. Body type
```shell
curl http://localhost:9110/v1/hello/abc
```

2. Guava CompletableFuture type
```shell
curl http://localhost:9110/v2/hello/abc
```

3. Jdk8 CompletableFuture type
```shell
curl http://localhost:9110/v3/hello/abc
```
