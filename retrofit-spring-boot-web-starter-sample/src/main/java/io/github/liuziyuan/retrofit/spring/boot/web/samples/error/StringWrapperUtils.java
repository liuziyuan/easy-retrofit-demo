package io.github.liuziyuan.retrofit.spring.boot.web.samples.error;

public class StringWrapperUtils {

    public static String formatWithStringFormat(String template, String value) {
        if (!template.contains("{}")) {
            return value;
        }
        return String.format(template.replace("{}", "%s"), value);
    }
}
