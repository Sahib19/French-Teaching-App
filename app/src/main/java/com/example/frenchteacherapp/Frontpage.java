package com.example.frenchteacherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frontpage extends AppCompatActivity {
   Button colorBtn , shapeBtn , commonPhraseBtn, familyMemberBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frontpage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        colorBtn = findViewById(R.id.colorButton);
        shapeBtn = findViewById(R.id.shapesButton);
        commonPhraseBtn =  findViewById(R.id.commonPhrasesButton);
        familyMemberBtn =  findViewById(R.id.familyMemberButton);

        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoColorPage();
            }
        });

        shapeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoShapePage();
            }
        });

        commonPhraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoCommonPage();
            }
        });

        familyMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFamilyPage();
            }
        });
    }

    void gotoColorPage(){
            Intent intent = new Intent ( this , MainActivity.class);
            startActivity(intent);
    }

    void gotoShapePage(){
        Intent intent = new Intent ( this , shape.class);
        startActivity(intent);
    }

    void gotoCommonPage(){
        Intent intent = new Intent ( this , commonphrases.class);
        startActivity(intent);
    }

    void  gotoFamilyPage(){
        Intent intent = new Intent ( this , family.class);
        startActivity(intent);
    }
}