package com.example.user.samallanimationproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 3/13/2018.
 */

public class ApiClient {

    public static final String JOSNURI = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if(retrofit==null){
                 retrofit =new Retrofit.Builder()
                         .baseUrl(JOSNURI)
                         .addConverterFactory(GsonConverterFactory.create())
                         .build();
        }
        return retrofit;
    }
}
