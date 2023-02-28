package com.example.showdatalist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class loginActivity2 extends AppCompatActivity {
    TextInputEditText logninemail, loginpassword;
    MaterialButton login_btn;
    MaterialTextView signup_text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        logninemail = findViewById(R.id.loginemail_id);
        loginpassword = findViewById(R.id.loginpassword_id);
        login_btn = findViewById(R.id.logintbtn_id);
        signup_text = findViewById(R.id.signup_text_id);
        Databasehelper db = new Databasehelper(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = logninemail.getText().toString();
                String Password = loginpassword.getText().toString();
                Log.d("nirav", "hello");

                if (Email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(loginActivity2.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean v = db.CheckEmailPassword(Email, Password);

                    if (v == true) {
                        Toast.makeText(loginActivity2.this, "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginActivity2.this,showdata_Activity2.class));

                        SharedPreferences preferences = getSharedPreferences("logindata",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("sp",v);
                        editor.apply();
                        finish();

                    } else {
                        Toast.makeText(loginActivity2.this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(loginActivity2.this, MainActivity.class));
            }
        });

    }
}