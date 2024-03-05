package io.github.liuziyuan.retrofit.samples.inherit.api;

import io.github.liuziyuan.retrofit.core.builder.BaseCallBackExecutorBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;

/**
 *
 * @author liuziyuan
 */
@Slf4j
public class CallBackExecutorBuilder extends BaseCallBackExecutorBuilder {

    @Override
    public Executor buildCallBackExecutor() {
        return command -> command.run();
    }
}
