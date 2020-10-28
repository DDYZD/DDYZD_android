package com.example.pangproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SignUpPage5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page5);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView con = findViewById(R.id.con);
        TextView explain = findViewById(R.id.explain);
        Button loginPage = findViewById(R.id.loginPage);

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpPage5.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}