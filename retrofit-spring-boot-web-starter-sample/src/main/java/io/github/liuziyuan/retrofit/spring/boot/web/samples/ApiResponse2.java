package io.github.liuziyuan.retrofit.spring.boot.web.samples;

public class ApiResponse2<T> {
    private String code;
    private String message;
    private T data;

    public ApiResponse2() {

    }

    public ApiResponse2(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse2<T> success() {
        return new ApiResponse2<>("200", "success", null);
    }

    public static <T> ApiResponse2<T> success(T data) {
        return new ApiResponse2<>("S", "success", data);
    }

    public static <T> ApiResponse2<T> success(String code, String message, T data) {
        return new ApiResponse2<>(code, message, data);
    }

    public static <T> ApiResponse2<T> failure(String code, String message) {
        return new ApiResponse2<>(code, message, null);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(T data) {
        this.data = data;
    }
}
