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

public class commonphrases extends AppCompatActivity implements View.OnClickListener{
Button gotoHome , please , how , thank, hello , excuseme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_commonphrases);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gotoHome = findViewById(R.id.home3);
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();

            }
        });

        // Connections of Main button with their id
        please = findViewById(R.id.please);
        how = findViewById(R.id.excuseme);
        hello = findViewById(R.id.thankyou);
        thank = findViewById(R.id.hello);
        excuseme = findViewById(R.id.howareyou);

        // passing the functions values
        please.setOnClickListener(this);
        how.setOnClickListener(this);
        hello.setOnClickListener(this);
        thank.setOnClickListener(this);
        excuseme.setOnClickListener(this);

    }

    public void gotoHomePage(){
        Intent intent = new Intent ( this , Frontpage.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.please){
            playSound(R.raw.please);
        }
        else if(id == R.id.excuseme){
            playSound(R.raw.howareyou);
        }
        else if(id == R.id.thankyou){
            playSound(R.raw.hello);
        }
        else if(id == R.id.hello){
            playSound(R.raw.thankyou);
        } else if (id == R.id.howareyou) {
            playSound(R.raw.excuseme);
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