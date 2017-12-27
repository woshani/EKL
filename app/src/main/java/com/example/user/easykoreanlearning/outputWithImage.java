package com.example.user.easykoreanlearning;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class outputWithImage extends AppCompatActivity {
    Button soundCharPlay;
    MediaPlayer charSound;
    TextView eng,kor,pro;
    String type;
    ImageView picviewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_with_image);

        String words = getIntent().getStringExtra("WORDS");
        String pronoun = getIntent().getStringExtra("PRONOUN");
        String indexer = getIntent().getStringExtra("INDEX");
        String korean = "";
        eng = (TextView)findViewById(R.id.textView7);
        kor = (TextView)findViewById(R.id.textView9);
        pro = (TextView)findViewById(R.id.textView10);
        picviewer = (ImageView)findViewById(R.id.imageView);

        switch (indexer){
            case "1":korean = getResources().getString(R.string.man);charSound= MediaPlayer.create(outputWithImage.this,R.raw.man);picviewer.setImageResource(R.drawable.ic_man);break;
            case "2":korean = getResources().getString(R.string.woman);charSound= MediaPlayer.create(outputWithImage.this,R.raw.woman);picviewer.setImageResource(R.drawable.ic_woman);break;
            case "3":korean = getResources().getString(R.string.student);charSound= MediaPlayer.create(outputWithImage.this,R.raw.student);picviewer.setImageResource(R.drawable.ic_student);break;
            case "4":korean = getResources().getString(R.string.friend);charSound= MediaPlayer.create(outputWithImage.this,R.raw.friends);picviewer.setImageResource(R.drawable.ic_friends);break;
            case "5":korean = getResources().getString(R.string.school);charSound= MediaPlayer.create(outputWithImage.this,R.raw.school);picviewer.setImageResource(R.drawable.ic_school);break;
            case "6":korean = getResources().getString(R.string.restaurant);charSound= MediaPlayer.create(outputWithImage.this,R.raw.restaurant);picviewer.setImageResource(R.drawable.ic_restaurant);break;
            case "7":korean = getResources().getString(R.string.bus);charSound= MediaPlayer.create(outputWithImage.this,R.raw.bus);picviewer.setImageResource(R.drawable.ic_bus);break;
            case "8":korean = getResources().getString(R.string.taxi);charSound= MediaPlayer.create(outputWithImage.this,R.raw.taxi);picviewer.setImageResource(R.drawable.ic_taxi);break;
            case "9":korean = getResources().getString(R.string.airplane);charSound= MediaPlayer.create(outputWithImage.this,R.raw.airplane);picviewer.setImageResource(R.drawable.ic_airplane);break;
            case "10":korean = getResources().getString(R.string.teacher);charSound= MediaPlayer.create(outputWithImage.this,R.raw.teacher);picviewer.setImageResource(R.drawable.ic_teacher);break;
        }

        Button back = (Button)findViewById(R.id.button29);
        soundCharPlay = (Button)findViewById(R.id.button30);

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
    View.OnClickListener goBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                Intent activityChangeIntent = new Intent(outputWithImage.this, selectSimpleWord.class);
                outputWithImage.this.startActivity(activityChangeIntent);
                finish();
        }
    };
    @Override
    public void onBackPressed() {
    }
}
