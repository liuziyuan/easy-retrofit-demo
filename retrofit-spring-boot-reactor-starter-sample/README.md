io.github.liuziyuan group, Deprecated
# retrofit spring boot Reactor starter samples
The request of HelloController will call itself BackendController

## how to test

1. WebFlux Mono type
```shell
curl http://localhost:9111/v1/hello/abc
```

2. Rxjava Observable to Mono type
```shell
curl http://localhost:9111/v2/hello/abc
```
