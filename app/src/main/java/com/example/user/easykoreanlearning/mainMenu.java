package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class mainMenu extends AppCompatActivity {

    ImageButton btnWord;
    ImageButton btnKrChar;
    ImageButton btnKrSent,btnKrGre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnWord = (ImageButton)findViewById(R.id.btnKrWords);
        btnKrChar = (ImageButton)findViewById(R.id.btnKrChar);
        btnKrSent = (ImageButton)findViewById(R.id.btnKrSent);
        btnKrGre = (ImageButton)findViewById(R.id.btnKrGreet);



        btnWord.setOnClickListener(gogogo);
        btnKrChar.setOnClickListener(gogo);
        btnKrSent.setOnClickListener(gogogogo);
        btnKrGre.setOnClickListener(gogogogogo);

    }

    View.OnClickListener gogogo = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent actWord = new Intent(mainMenu.this, selectSimpleWord.class);
            mainMenu.this.startActivity(actWord);
            finish();
        }
    };

    View.OnClickListener gogo = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent actSelect = new Intent(mainMenu.this, select.class);
            mainMenu.this.startActivity(actSelect);
            finish();
        }
    };

    OnClickListener gogogogogo = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent actSelect = new Intent(mainMenu.this, SelectGreetingActivity.class);
            mainMenu.this.startActivity(actSelect);
            finish();
        }
    };

    OnClickListener gogogogo = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent actSelect = new Intent(mainMenu.this, SelectSentencesActivity.class);
            mainMenu.this.startActivity(actSelect);
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
