package com.example.yudha.e_catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Session.SessionManager;

public class MainActivity extends AppCompatActivity {
    SessionManager sm;
    TextView tv1;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = new SessionManager(getApplicationContext());

        isLogin();
        ArrayList nama = sm.getDetail();
        tv1 = (TextView)findViewById(R.id.nama);
        tv1.setText(String.valueOf(nama.get(1)));

        logout = (Button)findViewById(R.id.buLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.isLogout();
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        });

    }

    public void isLogin(){
        SessionManager sm = new SessionManager(getApplicationContext());
        if(!sm.checkLogin()){
            Intent i = new Intent(getBaseContext(), LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }


}
