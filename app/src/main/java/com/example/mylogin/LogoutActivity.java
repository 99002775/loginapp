package com.example.mylogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class LogoutActivity extends Activity {

    String user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        //get username sent from the log in activity
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        user=b.getString("user");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    public void onStart(){
        super.onStart();
        TextView view=(TextView)findViewById(R.id.txtuser);
        view.setText("Welcome "+user);
    }


    public void logout(View view){
        SharedPreferences sharedPrefs =getSharedPreferences(MainActivity.PREFS_NAME,MODE_PRIVATE);
        Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.commit();
        user="";
        //show login form
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

