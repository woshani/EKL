package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectSimpleWord extends AppCompatActivity {
    Button btnW1,btnW2,btnW3,btnW5,btnW4,btnW6,btnW7,btnW9,btnW10,btnW11,btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        btnW1 = (Button) findViewById(R.id.btnW1);
        btnW2 = (Button) findViewById(R.id.btnW2);
        btnW3 = (Button) findViewById(R.id.btnW3);
        btnW4= (Button) findViewById(R.id.btnW4);
        btnW5= (Button) findViewById(R.id.btnW5);
        btnW6= (Button) findViewById(R.id.btnW6);
        btnW7= (Button) findViewById(R.id.btnW7);
        btnW9= (Button) findViewById(R.id.btnW9);
        btnW10= (Button) findViewById(R.id.btnW10);
        btnW11= (Button) findViewById(R.id.btnW11);

        btnW1.setOnClickListener(goOutput);
        btnW2.setOnClickListener(goOutput);
        btnW3.setOnClickListener(goOutput);
        btnW4.setOnClickListener(goOutput);
        btnW5.setOnClickListener(goOutput);
        btnW6.setOnClickListener(goOutput);
        btnW7.setOnClickListener(goOutput);
        btnW9.setOnClickListener(goOutput);
        btnW10.setOnClickListener(goOutput);
        btnW11.setOnClickListener(goOutput);



        btnHome = (Button)findViewById(R.id.buttonHomeS);
        btnHome.setOnClickListener(mainMenu);
    }


    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ImainMenu = new Intent(selectSimpleWord.this,mainMenu.class);
            selectSimpleWord.this.startActivity(ImainMenu);
            finish();
        }
    };

    View.OnClickListener goOutput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String words="";
            String pronoun = "";
            String indexer = "";
            String buttonText = ((Button)v).getText().toString();
            switch (buttonText){
                case "Man":words = "Man";pronoun="namja";indexer = "1";break;
                case "Woman":words = "Woman";pronoun="yeoja";indexer = "2";break;
                case "Student":words = "Student";pronoun="haksaeng";indexer = "3";break;
                case "Friend":words = "Friend";pronoun="chingu";indexer = "4";break;
                case "School":words = "School";pronoun="haggyo";indexer = "5";break;
                case "Restaurant":words = "Restaurant";pronoun="sigdang";indexer = "6";break;
                case "Bus":words = "Bus";pronoun="beoseu";indexer = "7";break;
                case "Taxi":words = "Taxi";pronoun="taegsi";indexer = "8";break;
                case "Airplane":words = "Airplane";pronoun="bihaeng-gi";indexer = "9";break;
                case "Teacher":words = "Teacher";pronoun="seonsaengnim";indexer = "10";break;
            }

            Intent activityChangeIntent = new Intent(selectSimpleWord.this, outputWithImage.class);
            activityChangeIntent.putExtra("WORDS", words);
            activityChangeIntent.putExtra("PRONOUN", pronoun);
            activityChangeIntent.putExtra("INDEX", indexer);
            selectSimpleWord.this.startActivity(activityChangeIntent);
            finish();
        }
    };
    @Override
    public void onBackPressed() {
    }
}
