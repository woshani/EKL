package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class outputNoImage extends AppCompatActivity {
    Button soundCharPlay;
    MediaPlayer charSound;
    TextView eng,kor,pro;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_no_image);
        String words = getIntent().getStringExtra("WORDS");
        String pronoun = getIntent().getStringExtra("PRONOUN");
        String indexer = getIntent().getStringExtra("INDEX");
        type = getIntent().getStringExtra("TYPE");
        String korean = "";
        eng = (TextView)findViewById(R.id.outputnoimageeng);
        kor = (TextView)findViewById(R.id.outputnoimagekr);
        pro = (TextView)findViewById(R.id.outputnoimagepr);

        switch (indexer){
            case "1":korean = getResources().getString(R.string.no_way);charSound= MediaPlayer.create(outputNoImage.this,R.raw.no_way);break;
            case "2":korean = getResources().getString(R.string.thank_you);charSound= MediaPlayer.create(outputNoImage.this,R.raw.thank_you);break;
            case "3":korean = getResources().getString(R.string.congratulation);charSound= MediaPlayer.create(outputNoImage.this,R.raw.congratulation);break;
            case "4":korean = getResources().getString(R.string.im_sorry);charSound= MediaPlayer.create(outputNoImage.this,R.raw.im_sorry);break;
            case "5":korean = getResources().getString(R.string.no);charSound= MediaPlayer.create(outputNoImage.this,R.raw.no);break;
            case "6":korean = getResources().getString(R.string.yes);charSound= MediaPlayer.create(outputNoImage.this,R.raw.yes);break;
            case "7":korean = getResources().getString(R.string.its_okay);charSound= MediaPlayer.create(outputNoImage.this,R.raw.it_s_okay);break;
            case "8":korean = getResources().getString(R.string.how_are_you);charSound= MediaPlayer.create(outputNoImage.this,R.raw.how_are_you);break;
            case "9":korean = getResources().getString(R.string.nice_to_meet_you);charSound= MediaPlayer.create(outputNoImage.this,R.raw.nice_to_meet_you);break;
            case "10":korean = getResources().getString(R.string.goodbye);charSound= MediaPlayer.create(outputNoImage.this,R.raw.goodbye);break;
            case "11":korean = getResources().getString(R.string.stay_well);charSound= MediaPlayer.create(outputNoImage.this,R.raw.stay_well);break;
            case "12":korean = getResources().getString(R.string.what_is_your_name);charSound= MediaPlayer.create(outputNoImage.this,R.raw.what_is_your_name);break;
        }

        Button back = (Button)findViewById(R.id.button17);
        soundCharPlay = (Button)findViewById(R.id.imageButton2);

        back.setOnClickListener(goBack);
        soundCharPlay.setOnClickListener(playSound);

        eng.setText(words);
        kor.setText(korean);
        pro.setText(pronoun);
    }

    View.OnClickListener playSound = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            charSound.start();
        }
    };

    View.OnClickListener goHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activityChangeIntent = new Intent(outputNoImage.this, mainMenu.class);
            outputNoImage.this.startActivity(activityChangeIntent);

            finish();
        }
    };

    View.OnClickListener goBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(type.equalsIgnoreCase("gree")){
                Intent activityChangeIntent = new Intent(outputNoImage.this, SelectGreetingActivity.class);
                outputNoImage.this.startActivity(activityChangeIntent);
                finish();
            }else if(type.equalsIgnoreCase("sent")){
                Intent activityChangeIntent = new Intent(outputNoImage.this, SelectSentencesActivity.class);
                outputNoImage.this.startActivity(activityChangeIntent);
                finish();
            }




        }
    };
    @Override
    public void onBackPressed() {
    }
}
