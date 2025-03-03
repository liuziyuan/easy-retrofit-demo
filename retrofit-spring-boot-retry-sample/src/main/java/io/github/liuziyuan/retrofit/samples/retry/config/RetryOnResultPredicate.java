package io.github.liuziyuan.retrofit.samples.retry.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.util.function.Predicate;

public class RetryOnResultPredicate implements Predicate<Response> {
    @SneakyThrows
    @Override
    public boolean test(Response response) {
        return !(response.code() == 200 || response.code() == 201);
    }
}
