package io.github.liuziyuan.retrofit.spring.boot.web.samples.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.easyretrofit.adapter.simplebody.ErrorParameter;
import io.github.easyretrofit.spring.boot.web.BodyCallAdapterErrorHandler;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;

@Component
public class AdapterSimpleBodyErrorHandler implements BodyCallAdapterErrorHandler {


    @Override
    public Object handleError(ErrorParameter errorParameter) {
        for (Annotation annotation : errorParameter.getAnnotations()) {
            if (annotation instanceof ErrorResponseBody) {
                return reflectErrorResponse((ErrorResponseBody) annotation, errorParameter.getResponse(), errorParameter.getReturnType());
            }
        }

        return null;
    }

    private static <R> R reflectErrorResponse(ErrorResponseBody annotation, Response response, Type returnType) throws RuntimeException {
        try {
            Class<?> clazz = Class.forName(returnType.getTypeName());
            Object returnBody = clazz.newInstance();
            if (annotation.codeType() != Objects.class && !annotation.codeFieldName().isEmpty()) {
                Field codeField = getField(annotation.codeFieldName(), clazz);
                if (codeField != null) {
                    codeField.setAccessible(true);
                    if (annotation.codeType().isAssignableFrom(String.class)) {
                        codeField.set(returnBody, String.valueOf(response.code()));
                    } else {
                        codeField.set(returnBody, String.valueOf(response.code()));
                    }
                }
            }
            if (annotation.messageType() != Objects.class && !annotation.messageFieldName().isEmpty()) {
                Field msgField = getField(annotation.messageFieldName(), clazz);
                if (msgField != null) {
                    msgField.setAccessible(true);
                    String messageWrapper = annotation.messageWrapper();
                    if (messageWrapper.isEmpty()) {
                        msgField.set(returnBody, response.toString());
                    } else {
                        msgField.set(returnBody, StringWrapperUtils.formatWithStringFormat(messageWrapper, response.toString()));
                    }

                }
            }
            return (R) returnBody;
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Field getField(String fieldName, Class<?> returnType) {
        try {
            return returnType.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
