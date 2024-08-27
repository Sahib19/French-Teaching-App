package com.example.frenchteacherapp;

//import com.example.frenchteacherapp.MainActivity;
import android.annotation.SuppressLint;
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

public class family extends AppCompatActivity implements View.OnClickListener{
Button  gotoHome , fatherBtn , motherBtn , sisterBtn , brotherBtn ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_family);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Connections of Main button with their id
        fatherBtn = findViewById(R.id.fatherbtn);
        motherBtn = findViewById(R.id.motherbtn);
        sisterBtn = findViewById(R.id.sisterbtn);
        brotherBtn = findViewById(R.id.brotherbtn);

        // passing the functions values
        fatherBtn.setOnClickListener(this);
        motherBtn.setOnClickListener(this);
        sisterBtn.setOnClickListener(this);
        brotherBtn.setOnClickListener(this);

        gotoHome = findViewById(R.id.home2);
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();

            }
        });
    }
    public void gotoHomePage(){
        Intent intent = new Intent ( this , Frontpage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.fatherbtn){
            playSound(R.raw.father);
        }
        else if(id == R.id.motherbtn){
            playSound(R.raw.mother);
        }
        else if(id == R.id.sisterbtn){
            playSound(R.raw.sister);
        }
        else if(id == R.id.brotherbtn){
            playSound(R.raw.brother);
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