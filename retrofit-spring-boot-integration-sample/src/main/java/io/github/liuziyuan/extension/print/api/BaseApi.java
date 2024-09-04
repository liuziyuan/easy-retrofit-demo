package io.github.liuziyuan.extension.print.api;


import io.github.easyretrofit.core.annotation.RetrofitBuilder;
import io.github.liuziyuan.retrofit.integration.spring.boot.web.PrintInfo;

/**
 * <p><b>Base URLs should always end in {@code /}.</b>
 * <p><b>Endpoint values which contain a leading {@code /} are absolute.</b>
 *
 * @author liuziyuan
 */
@PrintInfo(value = "info: ")
@RetrofitBuilder(baseUrl = "http://localhost:9100/")
public interface BaseApi {
}
