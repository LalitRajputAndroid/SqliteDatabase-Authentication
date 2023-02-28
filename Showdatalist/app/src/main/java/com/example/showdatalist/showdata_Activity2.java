package com.example.showdatalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class showdata_Activity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<modal> list;
    MaterialButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata2);

        logout = findViewById(R.id.logout_btn_id);
        recyclerView = findViewById(R.id.recycerV_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Databasehelper db = new Databasehelper(this);
        Cursor cursor = db.getdata();
        list = new ArrayList<>();

        while (cursor.moveToNext()){

            modal obj = new modal(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            list.add(obj);
        }
        myadapter myadapter = new myadapter(list);
        recyclerView.setAdapter(myadapter);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("logindata",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("sp",false);
                editor.apply();

                startActivity(new Intent(showdata_Activity2.this,loginActivity2.class));
            }
        });

    }
}