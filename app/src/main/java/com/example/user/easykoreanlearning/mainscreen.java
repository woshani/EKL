package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainscreen extends AppCompatActivity {
    private static int TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        //final View myLayout = findViewById(R.id.select);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(mainscreen.this, mainMenu.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
