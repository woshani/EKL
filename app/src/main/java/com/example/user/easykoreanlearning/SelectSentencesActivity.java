package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectSentencesActivity extends AppCompatActivity {
    Button btnHome,noway,congrat,itsokay,thank,sorry,yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sentences);
        btnHome = (Button)findViewById(R.id.button8);

        noway= (Button)findViewById(R.id.button3);
        congrat= (Button)findViewById(R.id.button);
        itsokay= (Button)findViewById(R.id.button7);
        thank= (Button)findViewById(R.id.button2);
        sorry= (Button)findViewById(R.id.button4);
        yes= (Button)findViewById(R.id.button6);
        no= (Button)findViewById(R.id.button5);


        noway.setOnClickListener(goOutput);
        congrat.setOnClickListener(goOutput);
        itsokay.setOnClickListener(goOutput);
        thank.setOnClickListener(goOutput);
        sorry.setOnClickListener(goOutput);
        yes.setOnClickListener(goOutput);
        no.setOnClickListener(goOutput);

        btnHome.setOnClickListener(mainMenu);
    }
    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ImainMenu = new Intent(SelectSentencesActivity.this,mainMenu.class);
            SelectSentencesActivity.this.startActivity(ImainMenu);
            finish();
        }
    };

    View.OnClickListener goOutput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String words="";
            String pronoun="";
            String indexer = "";
            String buttonText = ((Button)v).getText().toString();
            switch (buttonText){
                case "No Way":words = "No Way";pronoun="an dwaeyo";indexer="1";break;
                case "Thank You":words = "Thank You";pronoun="gamsahabnida";indexer="2";break;
                case "Congratulation":words = "Congratulation";pronoun="chugha hamnida";indexer="3";break;
                case "I'm Sorry":words = "I'm Sorry";pronoun="mianhabnida";indexer="4";break;
                case "No":words = "No";pronoun="aniyo";indexer="5";break;
                case "Yes":words = "Yes";pronoun="ne";indexer="6";break;
                case "It's Okay":words = "It's Okay";pronoun="gwaenchanayo";indexer="7";break;
            }

            Intent activityChangeIntent = new Intent(SelectSentencesActivity.this, outputNoImage.class);
            activityChangeIntent.putExtra("WORDS", words);
            activityChangeIntent.putExtra("PRONOUN", pronoun);
            activityChangeIntent.putExtra("INDEX", indexer);
            activityChangeIntent.putExtra("TYPE", "sent");
            SelectSentencesActivity.this.startActivity(activityChangeIntent);
            finish();
        }
    };
    @Override
    public void onBackPressed() {
    }
}
