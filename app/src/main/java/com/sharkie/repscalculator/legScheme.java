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
public class legScheme extends AppCompatActivity {

        public TextView workoutName, exerciseName, repsAmount, setsCount, textView6, textView7;
        public EditText repsInput, weightInput;
        public Button nextExercise, nextSet;
        public GifImageView exerciseGif;
        public String weightString, repsString;
        public float weight1, weight2, weight3,weight4, weight5, squatmax, squatleftmax, squatrightmax, hipmax, legcurlmax, deadliftmax, legextmax, calfmax;
        public int reps;


        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String SQUATMAX = "squatmax";
        public static final String SQUATRIGHTMAX = "squatrightmax";
        public static final String SQUATLEFTMAX = "squatleftmax";
        public static final String HIPMAX = "hipmax";
        public static final String LEGCURLMAX = "legcurlmax";
        public static final String DEADLIFTMAX =  "deadliftmax";
        public static final String LEGEXTMAX = "legextmax";
        public static final String CALFMAX = "calfmax";



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


            workoutName.setText("Leg Workout");
            textView6.setVisibility(View.VISIBLE);
            textView7.setVisibility(View.VISIBLE);
            repsInput.setVisibility(View.VISIBLE);
            weightInput.setVisibility(View.VISIBLE);
            nextExercise.setVisibility(View.VISIBLE);
            nextSet.setVisibility(View.INVISIBLE);


            loaddata();
            rowing();

        }


        public void rowing(){
            exerciseName.setText("Rowing machine");
            exerciseGif.setImageResource(R.drawable.rowing);
            repsAmount.setText("5 min");
            setsCount.setText("5 min");
            textView6.setVisibility(View.INVISIBLE);
            textView7.setVisibility(View.INVISIBLE);
            repsInput.setVisibility(View.INVISIBLE);
            weightInput.setVisibility(View.INVISIBLE);

            nextExercise.setOnClickListener(view -> squat());

        }


    public void squat(){
        exerciseName.setText("Squat");
        exerciseGif.setImageResource(R.drawable.barbellsquat);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatmax));
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
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight5 = (float) (weight4 + 5);
                        }

                       else if (reps < 10) {
                            weight5 = (float) (weight4 - 5);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, squatmax};
                            squatmax = 0;
                            for (float v : weightArray) {
                                squatmax = Math.max(squatmax, v);
                            }
                            squatLeft();

                        });

                    });

                });
            });
        });}

    public void squatLeft(){
        exerciseName.setText("Bulgarian split squat -left");
        exerciseGif.setImageResource(R.drawable.bulgsplitsquatleft);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatleftmax));
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

            else if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

           else  if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12 && weight4 >=10) {
                            weight5 = (float) (weight4 + 2);
                        }

                        else if (reps < 10 && weight4 >=12) {
                            weight5 = (float) (weight4 - 2);
                        }

                        else if (reps > 12 && weight4 <10){
                            weight5 = (float) (weight4 + 1);
                        }

                        else if (reps < 10 && weight4 <= 10){
                            weight5 = (float) (weight4 - 1);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, squatleftmax};
                            squatleftmax = 0;
                            for (float v : weightArray) {
                                squatleftmax = Math.max(squatleftmax, v);
                            }
                            squatRight();

                        });

                    });

                });
            });
        });
    }


    public void squatRight(){
        exerciseName.setText("Bulgarian split squat -right");
        exerciseGif.setImageResource(R.drawable.bulgsplitsquatright);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatrightmax));
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

            else if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12 && weight4 >=10) {
                            weight5 = (float) (weight4 + 2);
                        }

                        else if (reps < 10 && weight4 >=12) {
                            weight5 = (float) (weight4 - 2);
                        }

                        else if (reps > 12 && weight4 <10){
                            weight5 = (float) (weight4 + 1);
                        }

                        else if (reps < 10 && weight4 <= 10){
                            weight5 = (float) (weight4 - 1);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, squatrightmax};
                            squatrightmax = 0;
                            for (float v : weightArray) {
                                squatrightmax = Math.max(squatrightmax, v);
                            }
                            hipThrust();

                        });

                    });

                });
            });
        });
    }

    public void hipThrust(){
        exerciseName.setText("Hip thrust");
        exerciseGif.setImageResource(R.drawable.hipthrust);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(hipmax));
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
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight5 = (float) (weight4 + 5);
                        }

                        else if (reps < 10) {
                            weight5 = (float) (weight4 - 5);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, hipmax};
                            hipmax = 0;
                            for (float v : weightArray) {
                                hipmax = Math.max(hipmax, v);
                            }
                            legCurl();

                        });

                    });

                });
            });
        });}

    public void legCurl(){
        exerciseName.setText("Leg curl");
        exerciseGif.setImageResource(R.drawable.legcurl);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(legcurlmax));
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
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight5 = (float) (weight4 + 5);
                        }

                        else if (reps < 10) {
                            weight5 = (float) (weight4 - 5);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, legcurlmax};
                            legcurlmax = 0;
                            for (float v : weightArray) {
                                legcurlmax = Math.max(legcurlmax, v);
                            }
                            deadlift();

                        });

                    });

                });
            });
        });}

    public void deadlift(){
        exerciseName.setText("Deadlift");
        exerciseGif.setImageResource(R.drawable.deadlift);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(deadliftmax));
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
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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

                    else  if (reps < 10) {
                        weight4 = (float) (weight3 - 5);
                    }
                    else {
                        weight4 = weight3;
                    }
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight5 = (float) (weight4 + 5);
                        }

                        else if (reps < 10) {
                            weight5 = (float) (weight4 - 5);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, deadliftmax};
                            deadliftmax = 0;
                            for (float v : weightArray) {
                                deadliftmax = Math.max(deadliftmax, v);
                            }
                            legExt();

                        });

                    });

                });
            });
        });}

    public void legExt(){
        exerciseName.setText("Leg extension");
        exerciseGif.setImageResource(R.drawable.legextension);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(legextmax));
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
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight5 = (float) (weight4 + 5);
                        }

                        else if (reps < 10) {
                            weight5 = (float) (weight4 - 5);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, legextmax};
                            legextmax = 0;
                            for (float v : weightArray) {
                                legextmax = Math.max(legextmax, v);
                            }
                            calfRaise();

                        });

                    });

                });
            });
        });}

    public void calfRaise(){
        exerciseName.setText("Calf raises");
        exerciseGif.setImageResource(R.drawable.calfraise);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 5");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextExercise.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(calfmax));
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

            else if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else {
                weight2 = weight1;
            }
            setsCount.setText("2 of 5");
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
                setsCount.setText("3 of 5");
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
                    setsCount.setText("4 of 5");
                    weightInput.setText(String.valueOf(weight4));

                    nextSet.setOnClickListener(view111 -> {
                        if (TextUtils.isEmpty(weightInput.getText().toString())) {
                            weightInput.setError("Fill in the weight you used.");
                            return;
                        }
                        if (TextUtils.isEmpty(repsInput.getText().toString())) {
                            repsInput.setError("Fill in the amount of reps you did");
                            return;
                        }

                        weightString = String.valueOf(weightInput.getText());
                        weight4 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12 && weight4 >=10) {
                            weight5 = (float) (weight4 + 2);
                        }

                        else if (reps < 10 && weight4 >=12) {
                            weight5 = (float) (weight4 - 2);
                        }

                        else if (reps > 12 && weight4 <10){
                            weight5 = (float) (weight4 + 1);
                        }

                        else if (reps < 10 && weight4 <= 10){
                            weight5 = (float) (weight4 - 1);
                        }
                        else{
                            weight5 = weight4;
                        }
                        setsCount.setText("5 of 5");
                        weightInput.setText(String.valueOf(weight5));
                        nextSet.setVisibility(View.INVISIBLE);
                        nextExercise.setVisibility(View.VISIBLE);

                        nextExercise.setOnClickListener(view1111 -> {
                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, calfmax};
                            calfmax = 0;
                            for (float v : weightArray) {
                                calfmax = Math.max(calfmax, v);
                            }
                            running();

                        });

                    });

                });
            });
        });}

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
            startActivity(new Intent(legScheme.this, MainActivity.class));

        });
    }


    public void savedata() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(SQUATMAX,squatmax);
        editor.putFloat(SQUATRIGHTMAX,squatrightmax);
        editor.putFloat(SQUATLEFTMAX,squatleftmax);
        editor.putFloat(HIPMAX,hipmax);
        editor.putFloat(LEGCURLMAX,legcurlmax);
        editor.putFloat(DEADLIFTMAX,deadliftmax);
        editor.putFloat(LEGEXTMAX,legextmax);
        editor.putFloat(CALFMAX,calfmax);

        editor.apply();
    }

    public void loaddata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        squatmax = sharedPreferences.getFloat(SQUATMAX,squatmax);
        squatleftmax = sharedPreferences.getFloat(SQUATLEFTMAX,squatleftmax);
        squatrightmax = sharedPreferences.getFloat(SQUATRIGHTMAX,squatrightmax);
        hipmax = sharedPreferences.getFloat(HIPMAX,hipmax);
        legcurlmax = sharedPreferences.getFloat(LEGCURLMAX,legcurlmax);
        deadliftmax = sharedPreferences.getFloat(DEADLIFTMAX,deadliftmax);
        legextmax = sharedPreferences.getFloat(LEGEXTMAX,legextmax);
        calfmax = sharedPreferences.getFloat(CALFMAX,calfmax);

    }



    }