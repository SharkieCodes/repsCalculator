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
        public Button nextSet, bezetButton;
        public GifImageView exerciseGif;
        public String weightString, repsString;
        public float weight1, weight2, weight3,weight4, weight5, squatmax, legpressmax, squatleftmax, squatrightmax, hipmax, legcurlmax, legextmax, calfmax;
        public int reps;
        public boolean squatBezet, bulgBezet, hipBezet, legcurlBezet, legextBezet, calfBezet, legpressBezet;


        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String SQUATMAX = "squatmax";
        public static final String SQUATRIGHTMAX = "squatrightmax";
        public static final String SQUATLEFTMAX = "squatleftmax";
        public static final String HIPMAX = "hipmax";
        public static final String LEGCURLMAX = "legcurlmax";

        public static final String LEGEXTMAX = "legextmax";
        public static final String CALFMAX = "calfmax";

        public static final String LEGMAX = "legpressmax";



        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //alle begin waardes goedzetten

            setContentView(R.layout.workoutlayout);
            workoutName = findViewById(R.id.workoutName);
            exerciseName = findViewById(R.id.exerciseName);
            repsAmount = findViewById(R.id.repsAmount);
            setsCount = findViewById(R.id.setsCount);
            textView6 = findViewById(R.id.textView6);
            textView7 = findViewById(R.id.textView7);
            repsInput = findViewById(R.id.repsInput);
            weightInput = findViewById(R.id.weightInput);
            exerciseGif = findViewById(R.id.exerciseGif);
            nextSet = (Button) findViewById(R.id.nextSet);
            bezetButton = (Button) findViewById(R.id.bezetButton);


            workoutName.setText("Leg Workout");
            textView6.setVisibility(View.VISIBLE);
            textView7.setVisibility(View.VISIBLE);
            repsInput.setVisibility(View.VISIBLE);
            weightInput.setVisibility(View.VISIBLE);


            loaddata();
            rowing();

        }


        public void rowing(){

            //veranderd alleen de textviews en de GIF

            exerciseName.setText("Rowing machine");
            exerciseGif.setImageResource(R.drawable.rowing);
            repsAmount.setText("5 min");
            setsCount.setText("5 min");
            textView6.setVisibility(View.INVISIBLE);
            textView7.setVisibility(View.INVISIBLE);
            bezetButton.setVisibility(View.INVISIBLE);
            repsInput.setVisibility(View.INVISIBLE);
            weightInput.setVisibility(View.INVISIBLE);

            nextSet.setOnClickListener(view -> squat());

        }


    public void squat(){
            //veranderd de textviews en GIF
        exerciseName.setText("Squat");
        exerciseGif.setImageResource(R.drawable.barbellsquat);
        repsAmount.setText("6-8");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatmax));

        //als bezet is word hij naar het einde verplaatst

        if(!squatBezet){
            bezetButton.setVisibility(View.VISIBLE);
        }
        bezetButton.setOnClickListener(view -> {
            squatBezet = true;
            legpress();
        });

        //checken of alles is ingevuld
        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(weightInput.getText().toString())) {
                weightInput.setError("Fill in the weight you used.");
                return;
            }
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }

            //pakt alle waardes en kijkt of die <6, >8 of tussen 6-8 liggen

            weightString = String.valueOf(weightInput.getText());
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 8) {
                weight2 = (float) (weight1 + 5);
            }
            else if (reps < 6) {
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
//pakt alle waardes en kijkt of die <6, >8 of tussen 6-8 liggen
                weightString = String.valueOf(weightInput.getText());
                weight2 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 8) {
                    weight3 = (float) (weight2 + 5);
                }

                else if (reps < 6) {
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
//pakt alle waardes en kijkt of die <6, >8 of tussen 6-8 liggen
                    weightString = String.valueOf(weightInput.getText());
                    weight3 = Float.parseFloat(weightString);
                    repsString = String.valueOf(repsInput.getText());
                    reps = Integer.parseInt(repsString);

                    if (reps > 8) {
                        weight4 = (float) (weight3 + 5);
                    }

                    else if (reps < 6) {
                        weight4 = (float) (weight3 - 5);
                    }
                    else {
                        weight4 = weight3;
                    }



//pakt de maximale waarde voor het gewicht voor deze oefening en slaat die op
                            float[] weightArray = {weight1, weight2, weight3, weight4, squatmax};
                            squatmax = 0;
                            for (float v : weightArray) {
                                squatmax = Math.max(squatmax, v);
                            }
                            if(squatBezet){
                                squatBezet = false;
                                bezet();
                            }
                            else {

                                legpress();
                            }


                    });

                });
            });
        }
public void legpress(){
            exerciseName.setText("Leg press  -  legs close and at the top");
            exerciseGif.setImageResource(R.drawable.legpress);
            repsAmount.setText("10-12");
            setsCount.setText("1 of 3");
            textView6.setVisibility(View.VISIBLE);
            textView7.setVisibility(View.VISIBLE);
            repsInput.setVisibility(View.VISIBLE);
            weightInput.setVisibility(View.VISIBLE);
            bezetButton.setVisibility(View.INVISIBLE);
            nextSet.setVisibility(View.VISIBLE);
            weightInput.setText(String.valueOf(legpressmax));

            if (!legpressBezet){
                bezetButton.setVisibility((View.VISIBLE));
            }

            bezetButton.setOnClickListener(view -> {
                legpressBezet = true;
                squatLeft();
            });

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
                    weight2 = (float) (weight1 + 10);
                }
                else if (reps < 10) {
                    weight2 = (float) (weight1 - 10);
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
                        weight3 = (float) (weight2 + 10);
                    }

                    else if (reps < 10) {
                        weight3 = (float) (weight2 - 10);
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
                            weight4 = (float) (weight3 + 10);
                        }

                        else if (reps < 10) {
                            weight4 = (float) (weight3 - 10);
                        }
                        else {
                            weight4 = weight3;
                        }




                        float[] weightArray = {weight1, weight2, weight3, weight4, legpressmax};
                        legpressmax = 0;
                        for (float v : weightArray) {
                            legpressmax = Math.max(legpressmax, v);
                        }
                        if(legpressBezet){
                            legpressBezet = false;
                            bezet();
                        }
                        else {

                            squatLeft();
                        }


                    });

                });
            });
        }
    public void squatLeft(){
        exerciseName.setText("Bulgarian split squat -left");
        exerciseGif.setImageResource(R.drawable.bulgsplitsquatleft);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatleftmax));

        if (!bulgBezet){
            bezetButton.setVisibility(View.VISIBLE);
        }
        bezetButton.setOnClickListener(view -> {
            bulgBezet = true;
            hipThrust();
        });

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



                            float[] weightArray = {weight1, weight2, weight3, weight4, squatleftmax};
                            squatleftmax = 0;
                            for (float v : weightArray) {
                                squatleftmax = Math.max(squatleftmax, v);
                            }
                            if(bulgBezet){
                                squatRight();
                            }
                            else {
                                squatRight();
                            }


                    });

                });
            });
        }


    public void squatRight(){
        exerciseName.setText("Bulgarian split squat -right");
        exerciseGif.setImageResource(R.drawable.bulgsplitsquatright);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
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




                            float[] weightArray = {weight1, weight2, weight3, weight4, squatrightmax};
                            squatrightmax = 0;
                            for (float v : weightArray) {
                                squatrightmax = Math.max(squatrightmax, v);
                            }
                            if (bulgBezet){
                                bulgBezet = false;
                                bezet();
                            }
                            else {
                                hipThrust();
                            }


                    });

                });
            });
        }

    public void hipThrust(){
        exerciseName.setText("Hip thrust");
        exerciseGif.setImageResource(R.drawable.hipthrust);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(hipmax));

        if(!hipBezet){
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            hipBezet = true;
            legCurl();
        });

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




                            float[] weightArray = {weight1, weight2, weight3, weight4, hipmax};
                            hipmax = 0;
                            for (float v : weightArray) {
                                hipmax = Math.max(hipmax, v);
                            }
                            if (hipBezet){
                                hipBezet = false;
                                bezet();
                            }
                            else {
                                legCurl();
                            }


                    });

                });
            });
        }

    public void legCurl(){
        exerciseName.setText("Leg curl");
        exerciseGif.setImageResource(R.drawable.legcurl);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(legcurlmax));

        if(!legcurlBezet) {
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            legcurlBezet = true;
            legExt();
        });

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




                            float[] weightArray = {weight1, weight2, weight3, weight4, legcurlmax};
                            legcurlmax = 0;
                            for (float v : weightArray) {
                                legcurlmax = Math.max(legcurlmax, v);
                            }
                            if (legcurlBezet){
                                legcurlBezet = false;
                                bezet();
                            }
                            else {
                                legExt();
                            }


                    });

                });
            });
        }

    public void legExt(){
        exerciseName.setText("Leg extension");
        exerciseGif.setImageResource(R.drawable.legextension);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(legextmax));

        if(!legextBezet){
            bezetButton.setVisibility(View.VISIBLE);
        }
        bezetButton.setOnClickListener(view -> {
            legextBezet = true;
            calfRaise();
        });

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


                            float[] weightArray = {weight1, weight2, weight3, weight4, legextmax};
                            legextmax = 0;
                            for (float v : weightArray) {
                                legextmax = Math.max(legextmax, v);
                            }
                            if (legextBezet) {
                                legextBezet = false;
                                bezet();
                            }
                            else {
                                calfRaise();
                            }


                    });

                });
            });
        }

    public void calfRaise(){
        exerciseName.setText("Calf raises Barbell");
        exerciseGif.setImageResource(R.drawable.calfraise);
        repsAmount.setText("10-12");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(calfmax));

        if (!calfBezet){
            bezetButton.setVisibility(View.VISIBLE);
        }
        bezetButton.setOnClickListener(view -> {
            calfBezet = true;
            bezet();
        });

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

            if (reps > 12 && weight1 >=10 && weight1 < 30) {
                weight2 = (float) (weight1 + 2);
            }

            else if (reps < 10 && weight1 >=12 && weight1 <= 30) {
                weight2 = (float) (weight1 - 2);
            }

            else if (reps > 12 && weight1 <10){
                weight2 = (float) (weight1 + 1);
            }

            else if (reps < 10 && weight1 <= 10){
                weight2 = (float) (weight1 - 1);
            }
            else if (reps > 12 && weight1 >= 30){
                weight2 = (float) (weight1 + 5);
            }
            else if (reps < 10 && weight1 >= 35){
                weight2 = (float)  (weight1 - 5);
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

                if (reps > 12 && weight2 >=10 && weight2 < 30) {
                    weight3 = (float) (weight2 + 2);
                }

                else if (reps < 10 && weight2 >=12 && weight2 <= 30) {
                    weight3 = (float) (weight2 - 2);
                }

                else if (reps > 12 && weight2 <10){
                    weight3 = (float) (weight2 + 1);
                }

                else if (reps < 10 && weight2 <= 10){
                    weight3 = (float) (weight2 - 1);
                }
                else if (reps > 12 && weight2 >= 30){
                    weight3 = (float) (weight2 + 5);
                }
                else if (reps < 10 && weight2 >= 35){
                    weight3 = (float)  (weight2 - 5);
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

                    if (reps > 12 && weight3 >=10 && weight3 <30) {
                        weight4 = (float) (weight3 + 2);
                    }

                    else if (reps < 10 && weight3 >=12 && weight3 <= 30) {
                        weight4 = (float) (weight3 - 2);
                    }

                    else if (reps > 12 && weight3 <10){
                        weight4 = (float) (weight3 + 1);
                    }

                    else if (reps < 10 && weight3 <= 10){
                        weight4 = (float) (weight3 - 1);
                    }
                    else if (reps > 12 && weight3 >= 30){
                        weight4 = (float) (weight3 + 5);
                    }
                    else if (reps < 10 && weight3 >= 35){
                        weight4 = (float)  (weight3 - 5);
                    }
                    else {
                        weight4 = weight3;
                    }


                            float[] weightArray = {weight1, weight2, weight3, weight4, weight5, calfmax};
                            calfmax = 0;
                            for (float v : weightArray) {
                                calfmax = Math.max(calfmax, v);
                            }
                            if (calfBezet){
                                calfBezet = false;
                                bezet();
                            }
                            else{bezet();}




                    });

                });
            });
        }



//controleerd welke oefeningen bezet waren en doet deze
    public void bezet(){
        if (squatBezet){
            squat();
        }
        else if(legpressBezet){
            legpress();
        }
        else if(bulgBezet){
            squatLeft();
        }
        else if (hipBezet){
            hipThrust();
        }
        else if (legcurlBezet){
            legCurl();
        }
        else if (legextBezet){
            legExt();
        }
        else if (calfBezet){
            calfRaise();
        }
        else if (!squatBezet && !legpressBezet && !bulgBezet && !hipBezet && !legcurlBezet && !legextBezet && !calfBezet){
            running();
        }
    }
    public void running(){
        exerciseName.setText("threadmill");
        exerciseGif.setImageResource(R.drawable.running);
        repsAmount.setText("5 min");
        setsCount.setText("5 min");
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.INVISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.INVISIBLE);

        nextSet.setOnClickListener(view -> {
            savedata();
            startActivity(new Intent(legScheme.this, MainActivity.class));

        });
    }


    public void savedata() {
            //slaat alle maximale waardes voor de gewichten op

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(SQUATMAX,squatmax);
        editor.putFloat(SQUATRIGHTMAX,squatrightmax);
        editor.putFloat(SQUATLEFTMAX,squatleftmax);
        editor.putFloat(HIPMAX,hipmax);
        editor.putFloat(LEGCURLMAX,legcurlmax);
        editor.putFloat(LEGEXTMAX,legextmax);
        editor.putFloat(CALFMAX,calfmax);
        editor.putFloat(LEGMAX,legpressmax);

        editor.apply();
    }

    public void loaddata(){
            //laad alle maximum waardes en slaat ze op in een var

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        squatmax = sharedPreferences.getFloat(SQUATMAX,squatmax);
        squatleftmax = sharedPreferences.getFloat(SQUATLEFTMAX,squatleftmax);
        squatrightmax = sharedPreferences.getFloat(SQUATRIGHTMAX,squatrightmax);
        hipmax = sharedPreferences.getFloat(HIPMAX,hipmax);
        legcurlmax = sharedPreferences.getFloat(LEGCURLMAX,legcurlmax);
        legextmax = sharedPreferences.getFloat(LEGEXTMAX,legextmax);
        calfmax = sharedPreferences.getFloat(CALFMAX,calfmax);
        legpressmax = sharedPreferences.getFloat(LEGMAX,legpressmax);

    }



    }
