package io.github.liuziyuan.retrofit.samples.inherit.api;


import io.github.liuziyuan.retrofit.core.builder.BaseConverterFactoryBuilder;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author liuziyuan
 */
public class GsonConvertFactoryBuilder extends BaseConverterFactoryBuilder {
    @Override
    public Converter.Factory buildConverterFactory() {
        return GsonConverterFactory.create();
    }
}
