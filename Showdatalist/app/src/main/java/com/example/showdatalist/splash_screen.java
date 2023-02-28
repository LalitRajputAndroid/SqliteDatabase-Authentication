package com.example.showdatalist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                SharedPreferences preferences = getSharedPreferences("logindata",MODE_PRIVATE);
                boolean check = preferences.getBoolean("sp",false);
                if (check == true){
                    intent = new Intent(splash_screen.this,showdata_Activity2.class);
                }else {
                    intent = new Intent(splash_screen.this,loginActivity2.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}