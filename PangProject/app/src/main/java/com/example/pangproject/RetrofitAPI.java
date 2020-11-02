package com.example.pangproject;


import android.graphics.ColorSpace;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @POST("login")
    Call<Model__CheckAlready> postOverlapCheck(@Body CallApi modelCheckAlready);
}