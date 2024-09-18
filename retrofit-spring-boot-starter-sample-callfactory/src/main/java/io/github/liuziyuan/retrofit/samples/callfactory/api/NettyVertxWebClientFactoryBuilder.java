package io.github.liuziyuan.retrofit.samples.callfactory.api;

import io.github.easyretrofit.core.builder.BaseCallFactoryBuilder;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class NettyVertxWebClientFactoryBuilder extends BaseCallFactoryBuilder {
    @Override
    public Call.Factory buildCallFactory() {
        Vertx vertx = Vertx.vertx();
        WebClient client = WebClient.create(vertx, new WebClientOptions());
        return new Call.Factory() {
            @NotNull
            @Override
            public Call newCall(@NotNull Request request) {
                return new NettyVertxWebClientCall(request, client);
            }
        };
    }

    public static class NettyVertxWebClientCall implements Call {

        private final okhttp3.Request request;
        private final WebClient client;
        private volatile boolean cancelled;

        public NettyVertxWebClientCall(Request request, WebClient client) {
            this.request = request;
            this.client = client;
        }

        @Override
        public void cancel() {
            cancelled = true;
        }

        @NotNull
        @Override
        public Request request() {
            return this.request;
        }

        @NotNull
        @Override
        public Response execute() throws IOException {
            return null;
        }

        @Override
        public void enqueue(@NotNull Callback callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public boolean isCanceled() {
            return cancelled;
        }

        @NotNull
        @Override
        public Timeout timeout() {
            return null;
        }

        @NotNull
        @Override
        public Call clone() {
            return null;
        }
    }
}
