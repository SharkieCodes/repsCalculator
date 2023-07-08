package com.sharkie.repscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class workout extends AppCompatActivity {

    Button pushSchemeButton, pullSchemeButton, legSchemeButton;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutxml);

    pushSchemeButton = (Button) findViewById(R.id.pushSchemeButton);
    pullSchemeButton = (Button) findViewById(R.id.pullSchemeButton);
    legSchemeButton = (Button) findViewById(R.id.legsSchemeButton);



        pullSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, pullScheme.class)));

        legSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, legScheme.class)));


        pushSchemeButton.setOnClickListener(view -> startActivity(new Intent(workout.this, pushScheme.class)));


    }}
