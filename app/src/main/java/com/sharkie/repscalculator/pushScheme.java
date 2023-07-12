package com.sharkie.repscalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

@SuppressLint("SetTextI18n")
public class pushScheme extends AppCompatActivity {
    public TextView workoutName, exerciseName, repsAmount, setsCount, textView6, textView7;
    public EditText repsInput, weightInput;
    public Button nextExercise, nextSet;
    public GifImageView exerciseGif;
    public String weightString, repsString;
    public float weight1, weight2, weight3, weight4, weight5, benchmax, crossmax, butterflymax, shouldermax, inclinemax, frontmax, pushmax, extmax;
    public int reps;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String BENCHMAX = "benchmax";
    public static final String CROSSMAX = "crossmax";
    public static final String BUTTERFLYMAX = "butterflymax";
    public static final String SHOULDERMAX = "shouldermax";
    public static final String INCLINEMAX = "inclinemax";
    public static final String FRONTMAX = "frontmax";
    public static final String PUSHMAX = "pushmax";
    public static final String EXTMAX = "extmax";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutlayout);
        workoutName = findViewById(R.id.workoutName);
        exerciseName = findViewById(R.id.exerciseName);
        repsAmount = findViewById(R.id.repsAmount);
        setsCount = findViewById(R.id.setsCount);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        repsInput = findViewById(R.id.repsInput);
        weightInput = findViewById(R.id.weightInput);
        nextExercise = (Button) findViewById(R.id.nextExercise);
        exerciseGif = findViewById(R.id.exerciseGif);
        nextSet = (Button) findViewById(R.id.nextSet);


        workoutName.setText("Push Workout");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.INVISIBLE);


        loaddata();
        rowing();

    }

    public void rowing() {
        exerciseName.setText("Rowing machine");
        exerciseGif.setImageResource(R.drawable.rowing);
        repsAmount.setText("5 min");
        setsCount.setText("5 min");
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.INVISIBLE);

        nextExercise.setOnClickListener(view -> benchpress());

    }

    public void benchpress(){
        exerciseName.setText("Benchpress");
        exerciseGif.setImageResource(R.drawable.benchpress);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(benchmax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight2 = (float) (weight1 + 5);
            }

            else if (reps < 10) {
                weight2 = (float) (weight1 - 5);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12) {
                    weight3 = (float) (weight2 + 5);
                }

                else if (reps < 10) {
                    weight3 = (float) (weight2 - 5);
                }
                else {
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12) {
                        weight4 = (float) (weight3 + 5);
                    }

                    else if (reps < 10) {
                        weight4 = (float) (weight3 - 5);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, benchmax};
                            benchmax = 0;
                            for (float v : weightArray) {
                                benchmax = Math.max(benchmax, v);
                            }
                            cross();

                        });

                    });

                });
            });
        };

    public void cross(){
        exerciseName.setText("Crossover");
        exerciseGif.setImageResource(R.drawable.crossover);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(crossmax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight2 = (float) (weight1 + 2.5);
            }

            else if (reps < 10) {
                weight2 = (float) (weight1 - 2.5);
            }
            else{
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12) {
                    weight3 = (float) (weight2 + 2.5);
                }

                else  if (reps < 10) {
                    weight3 = (float) (weight2 - 2.5);
                }
                else{
                    weight3 = weight2;
                }
                    setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12) {
                        weight4 = (float) (weight3 + 2.5);
                    }

                    else  if (reps < 10) {
                        weight4 = (float) (weight3 - 2.5);
                    }
                    else{
                        weight4 = weight3;
                    }
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, crossmax};
                            crossmax = 0;
                            for (float v : weightArray) {
                                crossmax = Math.max(crossmax, v);
                            }
                            butterfly();

                        });

                    });

                });
            });
        };

    public void butterfly(){
        exerciseName.setText("Butterfly");
        exerciseGif.setImageResource(R.drawable.butterfly);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(butterflymax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12 && weight1 >=10) {
                weight2 = (float) (weight1 + 2);
            }

            else if (reps < 10 && weight1 >=12) {
                weight2 = (float) (weight1 - 2);
            }

            else  if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else  if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12 && weight2 >=10) {
                    weight3 = (float) (weight2 + 2);
                }

                else if (reps < 10 && weight2 >=12) {
                    weight3 = (float) (weight2 - 2);
                }

                else if (reps > 12 && weight2 <10){
                    weight3 = (float) (weight2 + 1);
                }

                else if (reps < 10 && weight2 <= 10){
                    weight3 = (float) (weight2 - 1);
                }
                else{
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12 && weight3 >=10) {
                        weight4 = (float) (weight3 + 2);
                    }

                    else if (reps < 10 && weight3 >=12) {
                        weight4 = (float) (weight3 - 2);
                    }

                    else if (reps > 12 && weight3 <10){
                        weight4 = (float) (weight3 + 1);
                    }

                    else if (reps < 10 && weight3 <= 10){
                        weight4 = (float) (weight3 - 1);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, butterflymax};
                            butterflymax = 0;
                            for (float v : weightArray) {
                                butterflymax = Math.max(butterflymax, v);
                            }
                            shoulderPress();

                        });

                    });

                });
            });
        };


    public void shoulderPress(){
        exerciseName.setText("Overhead shoulder press");
        exerciseGif.setImageResource(R.drawable.shoulderpress);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(shouldermax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12 && weight1 >=10) {
                weight2 = (float) (weight1 + 2);
            }

            else if (reps < 10 && weight1 >=12) {
                weight2 = (float) (weight1 - 2);
            }

            else  if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else  if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12 && weight2 >=10) {
                    weight3 = (float) (weight2 + 2);
                }

                else    if (reps < 10 && weight2 >=12) {
                    weight3 = (float) (weight2 - 2);
                }

                else    if (reps > 12 && weight2 <10){
                    weight3 = (float) (weight2 + 1);
                }

                else   if (reps < 10 && weight2 <= 10){
                    weight3 = (float) (weight2 - 1);
                }
                else{
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12 && weight3 >=10) {
                        weight4 = (float) (weight3 + 2);
                    }

                    else    if (reps < 10 && weight3 >=12) {
                        weight4 = (float) (weight3 - 2);
                    }

                    else   if (reps > 12 && weight3 <10){
                        weight4 = (float) (weight3 + 1);
                    }

                    else   if (reps < 10 && weight3 <= 10){
                        weight4 = (float) (weight3 - 1);
                    }
                    else{
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, shouldermax};
                            shouldermax = 0;
                            for (float v : weightArray) {
                                shouldermax = Math.max(shouldermax, v);
                            }
                            inclinePress();

                        });

                    });

                });
            });
        };

    public void inclinePress(){
        exerciseName.setText("Incline DB press");
        exerciseGif.setImageResource(R.drawable.inclinedbpress);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(inclinemax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12 && weight1 >=10) {
                weight2 = (float) (weight1 + 2);
            }

            else  if (reps < 10 && weight1 >=12) {
                weight2 = (float) (weight1 - 2);
            }

            else if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else  if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else{
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12 && weight2 >=10) {
                    weight3 = (float) (weight2 + 2);
                }

                else   if (reps < 10 && weight2 >=12) {
                    weight3 = (float) (weight2 - 2);
                }

                else  if (reps > 12 && weight2 <10){
                    weight3 = (float) (weight2 + 1);
                }

                else   if (reps < 10 && weight2 <= 10){
                    weight3 = (float) (weight2 - 1);
                }
                else {
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12 && weight3 >=10) {
                        weight4 = (float) (weight3 + 2);
                    }

                    else   if (reps < 10 && weight3 >=12) {
                        weight4 = (float) (weight3 - 2);
                    }

                    else   if (reps > 12 && weight3 <10){
                        weight4 = (float) (weight3 + 1);
                    }

                    else    if (reps < 10 && weight3 <= 10){
                        weight4 = (float) (weight3 - 1);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, inclinemax};
                            inclinemax = 0;
                            for (float v : weightArray) {
                                inclinemax = Math.max(inclinemax, v);
                            }
                            frontRaise();

                        });

                    });

                });
            });
        };


    public void frontRaise(){
        exerciseName.setText("Front raise");
        exerciseGif.setImageResource(R.drawable.frontraise);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(frontmax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12 && weight1 >=10) {
                weight2 = (float) (weight1 + 2);
            }

            else  if (reps < 10 && weight1 >=12) {
                weight2 = (float) (weight1 - 2);
            }

            else   if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else  if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12 && weight2 >=10) {
                    weight3 = (float) (weight2 + 2);
                }

                else if (reps < 10 && weight2 >=12) {
                    weight3 = (float) (weight2 - 2);
                }

                else   if (reps > 12 && weight2 <10){
                    weight3 = (float) (weight2 + 1);
                }

                else    if (reps < 10 && weight2 <= 10){
                    weight3 = (float) (weight2 - 1);
                }
                else {
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12 && weight3 >=10) {
                        weight4 = (float) (weight3 + 2);
                    }

                    else     if (reps < 10 && weight3 >=12) {
                        weight4 = (float) (weight3 - 2);
                    }

                    else   if (reps > 12 && weight3 <10){
                        weight4 = (float) (weight3 + 1);
                    }

                    else   if (reps < 10 && weight3 <= 10){
                        weight4 = (float) (weight3 - 1);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, frontmax};
                            frontmax = 0;
                            for (float v : weightArray) {
                                frontmax = Math.max(frontmax, v);
                            }
                            tricepPush();

                        });

                    });

                });
            });
        };


    public void tricepPush(){
        exerciseName.setText("Tricep pushdown");
        exerciseGif.setImageResource(R.drawable.triceppushdown);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(pushmax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight2 = (float) (weight1 + 2.5);
            }

            else if (reps < 10) {
                weight2 = (float) (weight1 - 2.5);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12) {
                    weight3 = (float) (weight2 + 2.5);
                }

                else if (reps < 10) {
                    weight3 = (float) (weight2 - 2.5);
                }
                else {
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12) {
                        weight4 = (float) (weight3 + 2.5);
                    }

                    else   if (reps < 10) {
                        weight4 = (float) (weight3 - 2.5);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, pushmax};
                            pushmax = 0;
                            for (float v : weightArray) {
                                pushmax = Math.max(pushmax, v);
                            }
                            tricepExt();

                        });

                    });

                });
            });
        };

    public void tricepExt(){
        exerciseName.setText("Tricep extension");
        exerciseGif.setImageResource(R.drawable.overheadtricep);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(extmax));
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight2 = (float) (weight1 + 2.5);
            }

            else  if (reps < 10) {
                weight2 = (float) (weight1 - 2.5);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 3");
            weightInput.setText(String.valueOf(weight2));

            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(weightInput.getText().toString())) {
                    weightInput.setError("Fill in the weight you used.");
                    return;
                }
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }

                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12) {
                    weight3 = (float) (weight2 + 2.5);
                }

                else  if (reps < 10) {
                    weight3 = (float) (weight2 - 2.5);
                }
                else {
                    weight3 = weight2;
                }
                setsCount.setText("3 of 3");
                weightInput.setText(String.valueOf(weight3));


                nextSet.setOnClickListener(view11 -> {
                    if (TextUtils.isEmpty(weightInput.getText().toString())) {
                        weightInput.setError("Fill in the weight you used.");
                        return;
                    }
                    if (TextUtils.isEmpty(repsInput.getText().toString())) {
                        repsInput.setError("Fill in the amount of reps you did");
                        return;
                    }

                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 12) {
                        weight4 = (float) (weight3 + 2.5);
                    }

                    else   if (reps < 10) {
                        weight4 = (float) (weight3 - 2.5);
                    }
                    else {
                        weight4 = weight3;
                    }

                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, extmax};
                            extmax = 0;
                            for (float v : weightArray) {
                                extmax = Math.max(extmax, v);
                            }
                            running();

                        });

                    });

                });
            });
        };


    public void running(){
        exerciseName.setText("threadmill");
        exerciseGif.setImageResource(R.drawable.running);
        repsAmount.setText("5 min");
        setsCount.setText("5 min");
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.INVISIBLE);

        nextExercise.setOnClickListener(view -> {
            savedata();
            startActivity(new Intent(pushScheme.this, MainActivity.class));

        });
    }


    public void savedata() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(BENCHMAX,benchmax);
        editor.putFloat(CROSSMAX,crossmax);
        editor.putFloat(BUTTERFLYMAX,butterflymax);
        editor.putFloat(SHOULDERMAX, shouldermax);
        editor.putFloat(INCLINEMAX,inclinemax);
        editor.putFloat(FRONTMAX,frontmax);
        editor.putFloat(PUSHMAX,pushmax);
        editor.putFloat(EXTMAX,extmax);
        editor.apply();
    }



    public void loaddata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        benchmax = sharedPreferences.getFloat(BENCHMAX,benchmax);
        crossmax = sharedPreferences.getFloat(CROSSMAX,crossmax);
        butterflymax = sharedPreferences.getFloat(BUTTERFLYMAX,butterflymax);
        shouldermax = sharedPreferences.getFloat(SHOULDERMAX,shouldermax);
        inclinemax = sharedPreferences.getFloat(INCLINEMAX,inclinemax);
        frontmax = sharedPreferences.getFloat(FRONTMAX,frontmax);
        pushmax = sharedPreferences.getFloat(PUSHMAX,pushmax);
        extmax = sharedPreferences.getFloat(EXTMAX,extmax);

    }
}