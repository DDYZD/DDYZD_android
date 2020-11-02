package com.example.pangproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar); // 프로그래스 바
        Button back = (Button)findViewById(R.id.back); // 로그인 화면으로 돌아가는 버튼
        ImageView logo2 = (ImageView)findViewById(R.id.logo2); // 팡 로고!
        TextView signtitle = (TextView)findViewById(R.id.signtitle); // 회원가입 말
        TextView explain = (TextView)findViewById(R.id.explain); // 설명 글
        TextView code = (TextView)findViewById(R.id.code); // 코드 말
        final EditText check = (EditText)findViewById(R.id.check); // 코드 입력 부분
        ImageButton signin=(ImageButton)findViewById(R.id.signin); // 다음 화면으로 가게 하는 기능




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpPage.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = check.getText().toString();
                if(check.getText().toString().length() == 0){
                    AlertDialog.Builder oh = new AlertDialog.Builder(SignUpPage.this);
                    oh.setIcon(R.mipmap.ic_launcher);
                    oh.setTitle("제목");
                    oh.setMessage("코드가 올바르지 않습니다");
                    oh.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(getApplicationContext(),"확인", Toast.LENGTH_LONG).show();
                        }
                    });
                    oh.setCancelable(false);
                    oh.show();
                }
                else{
                    Intent intent = new Intent(SignUpPage.this,SignUpPage2.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    finish();
                }
            }
        });
    }
}
