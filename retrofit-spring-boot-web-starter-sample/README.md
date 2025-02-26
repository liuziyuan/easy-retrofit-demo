io.github.liuziyuan group, Deprecated

# retrofit spring boot Reactor starter samples
The request of HelloController will call itself BackendController

## how to test

1. Body type
```shell
curl http://localhost:9111/v1/hello/abc
```

2. Guava ListenableFuture type
```shell
curl http://localhost:9111/v2/hello/abc
```

3. Jdk8 CompletableFuture type
```shell
curl http://localhost:9111/v3/hello/abc
```
1. String type
```shell
curl http://localhost:9111/v4/hello/abc
```