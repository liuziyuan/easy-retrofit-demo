package io.github.liuziyuan.retrofit.spring.boot.web.samples.error;

import java.lang.annotation.*;

/**
 * 处理HTTP请求返回异常的情况
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ErrorResponseBody {

    /**
     * 当前返回值中code字段名称
     * @return
     */
    String codeFieldName() default "";

    /**
     * 当前返回值中code字段类型
     * @return
     */
    Class<?> codeType() default Object.class;

    /**
     * 当前返回值中message字段名称
     * @return
     */
    String messageFieldName() default "";

    /**
     * 当前返回值中message字段类型
     * @return
     */
    Class<?> messageType() default Object.class;

    /**
     * 当前返回值中message包装的结构
     * @return
     */
    String messageWrapper() default "";
}
