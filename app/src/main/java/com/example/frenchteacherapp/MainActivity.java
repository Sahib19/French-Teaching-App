package com.example.frenchteacherapp;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
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


// Now we have to do the same things for 5 buttons which will increase th redunceny in the code
// in order to remove the code reduncency we will make the following changes
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
// View.OnClickListener is a interface that provide a way to handle click events on UI elements,
    // especially instances of the view class.
    Button blackBtn , yellowBtn , redBtn , greenBtn ,gotoHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.color_1_black);
        redBtn =  findViewById(R.id.color_2_red);
        greenBtn = findViewById(R.id.color_3_green);
        yellowBtn = findViewById(R.id.color_4_yellow);

        gotoHome = findViewById(R.id.home);
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();

            }
        });

        /*
        WE HAVE TO DO THIS SAME THINGS FOR ALL BUTTON , INSTEAD OF THIS DO THE BELOW THING
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     // here we use the Media Class as -> using new method -> MediaPlayer mediaPlayer = new MediaPlayer();
    // creating the media player using using the media player create() method.

                MediaPlayer mediaPlayer = MediaPlayer.create(
                        getApplicationContext(),
                        R.raw.red
                );
                mediaPlayer.start();
            }
        });*/

        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);

    }

    public void gotoHomePage(){
        Intent intent = new Intent ( this , Frontpage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sounds
        int clickBtnId = v.getId();
        if(clickBtnId == R.id.color_1_black){
            playSounds(R.raw.black);
        }
        else if (clickBtnId == R.id.color_2_red) {
            playSounds(R.raw.red);

        }
        else if (clickBtnId == R.id.color_3_green) {
            playSounds(R.raw.green);
        }
        else if (clickBtnId == R.id.color_4_yellow) {
            playSounds(R.raw.yellow);
        }
    }

    public void playSounds( int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
        this,
        id
        );

        mediaPlayer.start();
    }
}