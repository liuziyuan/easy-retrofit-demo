package io.github.liuziyuan.retrofit.samples.retrofitbuilder.api;

import io.github.liuziyuan.retrofit.extension.BaseConverterFactoryBuilder;
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
