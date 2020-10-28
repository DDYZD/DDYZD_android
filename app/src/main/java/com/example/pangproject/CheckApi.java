/*package com.example.pangproject;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckApi {
    public boolean callPhoneAlreadyCheck(int phoneNumber){
        boolean isRight = false;

        //Retrofit 호출
        Model__CheckAlready modelCheckAlready = new Model__CheckAlready(phoneNumber);
        Call<Model__CheckAlready> call = RetrofitClient.getApiService().postOverlapCheck(modelCheckAlready);
        call.enqueue(new Callback<Model__CheckAlready>() {
            @Override
            public void onResponse(Call<Model__CheckAlready> call, Response<Model__CheckAlready> response) {
                if(!response.isSuccessful()){
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                    return;
                }
                Model__CheckAlready checkAlready = response.body();
                Log.d("연결이 성공적 : ", response.body().toString());
                if(modelCheckAlready.getRequestPassward() == "아이디 혹은 패스워드가 일치하지 않습니다."){
                    Log.d("중복검사: ", "중복된 번호가 아닙니다");
                    modelCheckAlready.setRequestId(200);
                    System.out.println("ㅁㄴㅁㄴㅇㄹㅁㄴㅇ럼니어ㅏㄹ몬이ㅏㄹ"+modelCheckAlready.getRequestId());

                }
            }
            @Override
            public void onFailure(Call<Model__CheckAlready> call, Throwable t) {
                Log.e("연결실패", t.getMessage());
            }
        });

        return modelCheckAlready.isRight();
    }
}*/