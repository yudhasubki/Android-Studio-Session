package com.example.yudha.e_catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

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
        sm.getLoggedIn();

        ArrayList nama = sm.getDetail();

        tv1 = (TextView)findViewById(R.id.nama);
        tv1.setText(String.valueOf(nama.get(0)));

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

}
