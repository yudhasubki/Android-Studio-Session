package Session;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.yudha.e_catalog.LoginActivity;
import com.example.yudha.e_catalog.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yudha on 1/26/2017.
 */

public class SessionManager {
    SharedPreferences sessionManager;
    Activity activity;
    //Constructor
    public SessionManager(Context context){
         sessionManager = context.getSharedPreferences("myRef", Context.MODE_PRIVATE);
    }

    //Fungsi Menyimpan Data Saat Login
    public void saveData(String UserName){
        SharedPreferences.Editor editor = sessionManager.edit();
        editor.putString("UserName", UserName);
        editor.putBoolean("IsLoggedIn", true);
        editor.commit();
    }

    public boolean getLoggedIn(){
        return sessionManager.getBoolean("IsLoggedIn", true);
    }


    public String loadData(){
        String FileContent = sessionManager.getString("UserName","No Username");
        FileContent += "IsLoggedIn"+sessionManager.getBoolean("IsLoggedIn", false);
        return FileContent;
    }

    public ArrayList getDetail(){
        ArrayList add = new ArrayList();
        add.add(sessionManager.getString("UserName","No Session"));
        return add;
    }

    public void isLogout(){
        SharedPreferences.Editor editor = sessionManager.edit();
        editor.clear();
        editor.commit();

    }
}
