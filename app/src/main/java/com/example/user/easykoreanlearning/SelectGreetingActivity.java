package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectGreetingActivity extends AppCompatActivity {
    Button btnHome,how,nice,bye,well,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_greeting);
        btnHome = (Button)findViewById(R.id.button16);

        how = (Button)findViewById(R.id.button12);
        nice = (Button)findViewById(R.id.button10);
        bye = (Button)findViewById(R.id.button14);
        well = (Button)findViewById(R.id.button15);
        name = (Button)findViewById(R.id.button13);

        how.setOnClickListener(goOutput);
        nice.setOnClickListener(goOutput);
        bye.setOnClickListener(goOutput);
        well.setOnClickListener(goOutput);
        name.setOnClickListener(goOutput);
        btnHome.setOnClickListener(mainMenu);
    }
    View.OnClickListener mainMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ImainMenu = new Intent(SelectGreetingActivity.this,mainMenu.class);
            SelectGreetingActivity.this.startActivity(ImainMenu);
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
                case "How Are You?":words = "How Are You?";pronoun="jal jinaess-eoyo?";indexer="8";break;
                case "Nice To Meet You":words = "Nice To Meet You";pronoun="mannaseo bangawoyo";indexer="9";break;
                case "Goodbye":words = "Goodbye";pronoun="jalgayo";indexer="10";break;
                case "Stay Well":words = "Stay Well";pronoun="annyeonghigyeseyo";indexer="11";break;
                case "What Is Your Name?":words = "What Is Your Name?";pronoun="ileum-i mwo-eyo?";indexer="12";break;
            }

            Intent activityChangeIntent = new Intent(SelectGreetingActivity.this, outputNoImage.class);
            activityChangeIntent.putExtra("WORDS", words);
            activityChangeIntent.putExtra("PRONOUN", pronoun);
            activityChangeIntent.putExtra("INDEX", indexer);
            activityChangeIntent.putExtra("TYPE", "gree");
            SelectGreetingActivity.this.startActivity(activityChangeIntent);
            finish();
        }
    };
    @Override
    public void onBackPressed() {
    }
}
