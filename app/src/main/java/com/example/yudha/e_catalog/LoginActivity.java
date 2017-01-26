package com.example.yudha.e_catalog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import Session.SessionManager;
import layout.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    ImageView imageView;
    Drawable gambar;
    ByteArrayOutputStream out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        SessionManager sm = new SessionManager(getApplicationContext());
        if(sm.getLoggedIn() == false){
            isSession();
        }
    }

    public void buLogin(View v){
        FragmentManager fm = getSupportFragmentManager();
        LoginFragment lf = new LoginFragment();
        lf.show(fm, "Show Fragment");
    }

    public void isSession(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
