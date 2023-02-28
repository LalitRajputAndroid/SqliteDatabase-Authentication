package com.example.showdatalist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username,emailaddress,password;
    MaterialButton submit;
    MaterialTextView logintext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Databasehelper db = new Databasehelper(this);
        username = findViewById(R.id.username_id);
        emailaddress = findViewById(R.id.email_id);
        password = findViewById(R.id.password_id);
        submit = findViewById(R.id.submitbtn_id);
        logintext = findViewById(R.id.login_text_id);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = username.getText().toString();
                String email = emailaddress.getText().toString();
                String pass = password.getText().toString();
                Intent intent = new Intent(MainActivity.this,showdata_Activity2.class);

                if (name.isEmpty() || email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "fill the field", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean i = db.insertdata(name,email,pass);

                    if (i==true){

                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Save data", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        emailaddress.setText("");
                        password.setText("");
                        finish();

                    }else
                        Toast.makeText(MainActivity.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,loginActivity2.class));
            }
        });
    }
}