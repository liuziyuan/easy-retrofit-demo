package io.github.liuziyuan.retrofit.samples.retrofitbuilder.api;

import io.github.liuziyuan.retrofit.extension.BaseCallBackExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuziyuan
 */
@Slf4j
@Component
public class MyRetrofitCallBackExecutor extends BaseCallBackExecutor {
    @Override
    public void execute(Runnable command) {
        final Thread thread = new Thread(command);
        thread.start();
        log.info("MyRetrofitCallBackExecutor started");
    }
}
