package com.example.frenchteacherapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class shape extends AppCompatActivity implements View.OnClickListener{
Button gotoHome , circleBtn  ,rectangleBtn ,squareBtn,ovalBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shape);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gotoHome = findViewById(R.id.home4);
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();

            }
        });

        // Connections of Main button with their id
        circleBtn = findViewById(R.id.button);
        rectangleBtn = findViewById(R.id.button6);
        squareBtn = findViewById(R.id.button7);
        ovalBtn = findViewById(R.id.button5);

        // passing the functions values
        circleBtn.setOnClickListener(this);
        rectangleBtn.setOnClickListener(this);
        squareBtn.setOnClickListener(this);
        ovalBtn.setOnClickListener(this);

    }
    public void gotoHomePage(){
        Intent intent = new Intent ( this , Frontpage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.button){
            playSound(R.raw.cirle);
        }
        else if(id == R.id.button6){
            playSound(R.raw.rectangle);
        }
        else if(id == R.id.button7){
            playSound(R.raw.square);
        }
        else if(id == R.id.button5){
            playSound(R.raw.oval);
        } else if (id == R.id.home2) {
            gotoHomePage();
        }
    }

    void playSound (int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}