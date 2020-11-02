package com.example.pangproject;

import com.example.pangproject.RetrofitAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.156.147.146/";

    @NotNull
    public static Model__CheckAlready getApiService(){return getInstance().create(Model__CheckAlready.class);}

    @org.jetbrains.annotations.NotNull
    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
