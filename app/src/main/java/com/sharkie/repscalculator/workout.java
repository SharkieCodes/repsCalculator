package com.sharkie.repscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class workout extends AppCompatActivity {

    Button pushSchemeButton, pullSchemeButton, legSchemeButton, omaButton;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutxml);


        //kijkt of de knoppen ingedrukt worden en opent daarna de workout die bij die knop hoort

    pushSchemeButton = (Button) findViewById(R.id.pushSchemeButton);
    pullSchemeButton = (Button) findViewById(R.id.pullSchemeButton);
    legSchemeButton = (Button) findViewById(R.id.legsSchemeButton);
    omaButton = (Button) findViewById(R.id.mamaButton);




        pullSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, pullScheme.class)));

        legSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, legScheme.class)));

        pushSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, pushScheme.class)));

        omaButton.setOnClickListener(view -> startActivity(new Intent(workout.this, workoutMama.class)));


    }}
