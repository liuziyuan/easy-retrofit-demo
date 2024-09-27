io.github.liuziyuan group, Deprecated

# How to use

Please note to match the versions of springboot and springcloud , https://spring.io/projects/spring-cloud#overview


1. Start Eureka Server

```shell
java -jar eureka.jar
```
2. Start web service

3. Start reactor service

# Run tests

## web service tests
```shell

curl http://localhost:9201/web/abc
```

```shell

curl http://localhost:9201/web2/abc
```

## reactor service tests
```shell
curl http://localhost:9202/reactor1/abc
```

```shell
curl http://localhost:9202/reactor2/abc
```