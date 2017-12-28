package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class select extends AppCompatActivity {
    //declare the button
    Button btnI,btnO,btnU,btnA,btnG,btnD,btnNG,btnS,btnN,btnM,btnHome,btnJIEUT,btnHIEUT,btnOH,btnUH,btnYAH,btnYUH,btnYOH,btnYOO,btnAE,btnRIEUL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        //initialize the button
        btnA = (Button) findViewById(R.id.button25);
        btnD = (Button) findViewById(R.id.button23);
        btnG = (Button) findViewById(R.id.button24);
        btnI= (Button) findViewById(R.id.button28);
        btnM= (Button) findViewById(R.id.button11);
        btnN= (Button) findViewById(R.id.button20);
        btnNG= (Button) findViewById(R.id.button22);
        btnO= (Button) findViewById(R.id.button27);
        btnS= (Button) findViewById(R.id.button21);
        btnU= (Button) findViewById(R.id.button26);

        btnJIEUT = (Button) findViewById(R.id.button19);
        btnHIEUT = (Button) findViewById(R.id.button31);
        btnOH = (Button) findViewById(R.id.button33);
        btnUH = (Button) findViewById(R.id.button18);
        btnYAH = (Button) findViewById(R.id.button34);
        btnYUH = (Button) findViewById(R.id.button35);
        btnYOH = (Button) findViewById(R.id.button36);
        btnYOO = (Button) findViewById(R.id.button38);
        btnAE = (Button) findViewById(R.id.button39);
        btnRIEUL = (Button) findViewById(R.id.button37);

        btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(mainMenu);

        btnA.setOnClickListener(goOutput);
        btnD.setOnClickListener(goOutput);
        btnG.setOnClickListener(goOutput);
        btnI.setOnClickListener(goOutput);
        btnM.setOnClickListener(goOutput);
        btnN.setOnClickListener(goOutput);
        btnNG.setOnClickListener(goOutput);
        btnO.setOnClickListener(goOutput);
        btnS.setOnClickListener(goOutput);
        btnU.setOnClickListener(goOutput);

        btnJIEUT.setOnClickListener(goOutput);
        btnHIEUT.setOnClickListener(goOutput);
        btnOH.setOnClickListener(goOutput);
        btnUH.setOnClickListener(goOutput);
        btnYAH.setOnClickListener(goOutput);
        btnYUH.setOnClickListener(goOutput);
        btnYOH.setOnClickListener(goOutput);
        btnYOO.setOnClickListener(goOutput);
        btnAE.setOnClickListener(goOutput);
        btnRIEUL.setOnClickListener(goOutput);

    }

    View.OnClickListener goOutput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String words="";
            String buttonText = ((Button)v).getText().toString();
            switch (buttonText){
                case "ㅣ":words = "i";break;
                case "ㅗ":words = "o";break;
                case "ㅜ":words = "u";break;
                case "ㅏ":words = "a";break;
                case "ㄱ":words = "g";break;
                case "ㄷ":words = "d";break;
                case "ㅇ":words = "ng";break;
                case "ㅅ":words = "s";break;
                case "ㄴ":words = "n";break;
                case "ㅁ":words = "m";break;
                case "ㅈ":words = "j";break;
                case "ㅎ":words = "h";break;
                case "ㅓ":words = "eo";break;
                case "ㅡ":words = "eu";break;
                case "ㅑ":words = "ya";break;
                case "ㅕ":words = "yeo";break;
                case "ㅛ":words = "yo";break;
                case "ㅠ":words = "yu";break;
                case "ㅐ":words = "ae";break;
                case "ㄹ":words = "r";break;
            }

            Intent activityChangeIntent = new Intent(select.this, output.class);
            activityChangeIntent.putExtra("WORDS", words);
            activityChangeIntent.putExtra("KOREAN", buttonText);
            // currentContext.startActivity(activityChangeIntent);
            select.this.startActivity(activityChangeIntent);
//            Toast.makeText(getApplicationContext(),"This is the text button: "+buttonText+" and this the word equivalent for the korean words: "+words, Toast.LENGTH_SHORT).show();// Set your own toast  message

            finish();
        }
    };

    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ImainMenu = new Intent(select.this,mainMenu.class);
            select.this.startActivity(ImainMenu);
            finish();
        }
    };

    @Override
    public void onBackPressed() {
    }
}
