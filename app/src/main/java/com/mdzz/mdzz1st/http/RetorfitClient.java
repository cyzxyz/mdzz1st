package com.mdzz.mdzz1st.http;

import dagger.Module;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Raymond on 2016/11/17.
 */
@Module
public class RetorfitClient {

    private Retrofit retrofit;

    public RetorfitClient(){
        this.retrofit =new  Retrofit.Builder().baseUrl("http://v.juhe.cn/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public <T> T creatService(final Class<T> service){
        return  retrofit.create(service);
    }
}
