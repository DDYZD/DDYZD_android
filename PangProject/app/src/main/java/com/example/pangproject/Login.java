package com.example.pangproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {


    private String TAG = getClass().getSimpleName();

    private final String BASE_URL="http://10.156.147.146/";
    private RetrofitAPI mRetrofitAPI;

    private EditText id;
    private EditText passward;
    private Button signed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ImageView logo1 = (ImageView) findViewById(R.id.logo1); //로고
        final EditText id1 = (EditText) findViewById(R.id.id11); // 아이디 입력창
        EditText passward = (EditText) findViewById(R.id.passward); // 비밀번호 입력 창
        Button login = (Button) findViewById(R.id.login);// 로그인
        TextView question = (TextView) findViewById(R.id.question); //문구
        final Button signed = (Button) findViewById(R.id.signed);// 회원가입 창




        login.setOnClickListener(new View.OnClickListener() {
            public boolean callPhoneAlreadyCheck(int phoneNumber){
                boolean isRight = false;
                String idapi = id1.getText().toString();
                String psapi = passward.getText().toString();
                CallApi.requestId = idapi;
                CallApi.requestPassward = psapi;

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
                            System.out.println("ggggggggggggggggggggggg"+modelCheckAlready.getRequestId());

                        }
                    }
                    @Override
                    public void onFailure(Call<Model__CheckAlready> call, Throwable t) {
                        Log.e("연결실패", t.getMessage());
                    }
                });

                return modelCheckAlready.isRight();
            }
            @Override
            public void onClick(View view) {
                int a= Model__CheckAlready.responseId;
                String b = Model__CheckAlready.responsePassward;

                System.out.println("aaaaaaaaaaaaaaaaaa" + a);
                if (a == 200) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder oh = new AlertDialog.Builder(Login.this);
                    oh.setIcon(R.mipmap.ic_launcher);
                    oh.setTitle("제목");
                    oh.setMessage("코드가 올바르지 않습니다");
                    oh.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(getApplicationContext(), "확인", Toast.LENGTH_LONG).show();
                        }
                    });
                    oh.setCancelable(false);
                    oh.show();
                }
            }
        });

        signed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUpPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}