package com.sharkie.repscalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Defining da buttons
    ImageButton workoutButton, weightButton;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutButton = (ImageButton) findViewById(R.id.workoutButton);
        weightButton = (ImageButton) findViewById(R.id.weightButton);

        workoutButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, workout.class)));

        weightButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, weight.class)));}}


