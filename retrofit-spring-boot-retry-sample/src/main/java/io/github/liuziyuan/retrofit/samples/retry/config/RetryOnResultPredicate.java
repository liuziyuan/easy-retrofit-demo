package io.github.liuziyuan.retrofit.samples.retry.config;

import okhttp3.Response;

import java.util.function.Predicate;

public class RetryOnResultPredicate implements Predicate<Response> {
    @Override
    public boolean test(Response response) {
        return response.code() == 400;
    }
}
