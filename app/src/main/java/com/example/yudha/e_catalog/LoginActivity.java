package com.example.yudha.e_catalog;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import Session.SessionManager;
import layout.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        isLogin();
    }

    public void buLogin(View v){
        FragmentManager fm = getSupportFragmentManager();
        LoginFragment lf = new LoginFragment();
        lf.show(fm, "Show Fragment");
    }

    public void isLogin(){
        SessionManager sm = new SessionManager(getApplicationContext());
        if(sm.checkLogin()){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }
    }
}
