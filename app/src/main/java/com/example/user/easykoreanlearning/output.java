package com.example.user.easykoreanlearning;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class output extends AppCompatActivity {
    GestureLibrary gestureLibrary = null;
    GestureOverlayView gestureOverlayView;
    TextView gestureResult;
    Button soundCharPlay;
    MediaPlayer charSound;
    public int id = 0;
    public String gWord="";
    public String gkorean="";
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        String words = getIntent().getStringExtra("WORDS");
        String korean = getIntent().getStringExtra("KOREAN");
        //initialized the textview by using find the id in the xml file
        //TextView title = (TextView)findViewById(R.id.titleWords);
        Button back = (Button)findViewById(R.id.btnBack1);
        soundCharPlay = (Button)findViewById(R.id.button9);
        gestureResult = (TextView)findViewById(R.id.gestureResult);
        gestureOverlayView = (GestureOverlayView)findViewById(R.id.gestures);
        //Toast.makeText(getApplicationContext(),"The data is "+words+" and "+korean, Toast.LENGTH_SHORT).show();// Set your own toast  message

        switch (words){
            case "i":id= R.raw.i;gestureResult.setBackgroundResource(R.drawable.i);charSound= MediaPlayer.create(output.this,R.raw.e_char);break;
            case "o":id= R.raw.o;gestureResult.setBackgroundResource(R.drawable.o);charSound= MediaPlayer.create(output.this,R.raw.o_char);break;
            case "u":id= R.raw.u;gestureResult.setBackgroundResource(R.drawable.u);charSound= MediaPlayer.create(output.this,R.raw.u_char);break;
            case "a":id= R.raw.a;gestureResult.setBackgroundResource(R.drawable.a);charSound= MediaPlayer.create(output.this,R.raw.a_char);break;
            case "g":id= R.raw.g;gestureResult.setBackgroundResource(R.drawable.g);charSound= MediaPlayer.create(output.this,R.raw.g_char);break;
            case "d":id= R.raw.d;gestureResult.setBackgroundResource(R.drawable.d);charSound= MediaPlayer.create(output.this,R.raw.d_char);break;
            case "ng":id= R.raw.ng;gestureResult.setBackgroundResource(R.drawable.ng);charSound= MediaPlayer.create(output.this,R.raw.ng_char);break;
            case "s":id= R.raw.s;gestureResult.setBackgroundResource(R.drawable.s);charSound= MediaPlayer.create(output.this,R.raw.s_char);break;
            case "n":id= R.raw.n;gestureResult.setBackgroundResource(R.drawable.n);charSound= MediaPlayer.create(output.this,R.raw.n_char);break;
            case "m":id= R.raw.m;gestureResult.setBackgroundResource(R.drawable.m);charSound= MediaPlayer.create(output.this,R.raw.m_char);break;
            case "j":id= R.raw.j;gestureResult.setBackgroundResource(R.drawable.j);charSound= MediaPlayer.create(output.this,R.raw.j_char);break;
            case "h":id= R.raw.h;gestureResult.setBackgroundResource(R.drawable.h);charSound= MediaPlayer.create(output.this,R.raw.h_char);break;
            case "eo":id= R.raw.eo;gestureResult.setBackgroundResource(R.drawable.eo);charSound= MediaPlayer.create(output.this,R.raw.eo_char);break;
            case "eu":id= R.raw.eu;gestureResult.setBackgroundResource(R.drawable.eu);charSound= MediaPlayer.create(output.this,R.raw.eu_char);break;
            case "ya":id= R.raw.ya;gestureResult.setBackgroundResource(R.drawable.ya);charSound= MediaPlayer.create(output.this,R.raw.ya_char);break;
            case "yeo":id= R.raw.yeo;gestureResult.setBackgroundResource(R.drawable.yeo);charSound= MediaPlayer.create(output.this,R.raw.yeo_char);break;
            case "yo":id= R.raw.yo;gestureResult.setBackgroundResource(R.drawable.yo);charSound= MediaPlayer.create(output.this,R.raw.yo_char);break;
            case "yu":id= R.raw.yu;gestureResult.setBackgroundResource(R.drawable.yu);charSound= MediaPlayer.create(output.this,R.raw.yu_char);break;
            case "ae":id= R.raw.ae;gestureResult.setBackgroundResource(R.drawable.ae);charSound= MediaPlayer.create(output.this,R.raw.ae_char);break;
            case "r":id= R.raw.r;gestureResult.setBackgroundResource(R.drawable.r);charSound= MediaPlayer.create(output.this,R.raw.r_char);break;
            case "":id= R.raw.m;break;
        }
        //gestureResult.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_i, 0, 0, 0);
        gWord=words;
        gkorean = korean;
        //title.setText(korean+" = "+words);
        gestureLibrary = GestureLibraries.fromRawResource(this, id);
        gestureLibrary.load();
        gestureOverlayView.addOnGesturePerformedListener(gesturePerformedListener);
        back.setOnClickListener(goBack);
        soundCharPlay.setOnClickListener(playSound);

    }
    View.OnClickListener playSound = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            charSound.start();
        }
    };

    OnGesturePerformedListener gesturePerformedListener = new OnGesturePerformedListener(){
        @Override
        public void onGesturePerformed(GestureOverlayView view, Gesture gesture) {
            // TODO Auto-generated method stub
            ArrayList<Prediction> prediction = gestureLibrary.recognize(gesture);
            Prediction p = prediction.get(0);

            if(prediction.size() > 0){
                if(p.score > 1){
                    //gestureResult.setText(prediction.get(0).name);
                    Toast.makeText(getApplicationContext(),"The korean word you just draw is "+gWord, Toast.LENGTH_SHORT).show();// Set your own toast  message

                }
            }

        }};

    View.OnClickListener goHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activityChangeIntent = new Intent(output.this, mainMenu.class);
            output.this.startActivity(activityChangeIntent);

            finish();
        }
    };

    View.OnClickListener goBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activityChangeIntent = new Intent(output.this, select.class);
            output.this.startActivity(activityChangeIntent);

            finish();
        }
    };

    @Override
    public void onBackPressed() {
    }

}
