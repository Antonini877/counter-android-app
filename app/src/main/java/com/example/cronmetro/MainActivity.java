package com.example.cronmetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Chronometer ch;
    private ImageButton b;
    private Button r;
    private boolean clicado = false;
    private long v_a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.conta);
        r = findViewById(R.id.button2);
        ch = (Chronometer)findViewById(R.id.chron);


    }

    public void reset(View view){
        ch.stop();
        ch.setBase(SystemClock.elapsedRealtime());
        this.v_a = 0;
        this.clicado = false;
    }

    public void contar(View view){
        startC(this.clicado);
    }
    public void startC(boolean b){
        if(!b){
            ch.setBase(SystemClock.elapsedRealtime()-this.v_a);
            ch.start();
            this.clicado = true;
        }else{
            ch.stop();
            this.v_a = SystemClock.elapsedRealtime() - ch.getBase();
            this.clicado = false;
        }

    }
}