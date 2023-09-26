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
public class workoutMama extends AppCompatActivity {


    /*
    workout voor mama, precies hetzelfde als de andere workouts
     */
    public TextView workoutName, exerciseName, repsAmount, setsCount, textView6, textView7;
    public EditText repsInput, weightInput;
    public Button nextSet, bezetButton;
    public GifImageView exerciseGif;
    public String weightString, repsString;
    public float weight1, weight2, weight3,weight4, weight5, squatmax, lungemax, absmax;
    public int reps;
    public boolean ellipBezet, seatedBiBezet, absBezet, rennenBezet, squatBezet, lungeBezet, fietsBezet;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SQUATMAX = "squatmax";
    public static final String LUNGEMAX = "lungemax";
    public static final String ABSMAX = "absmax";




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
        exerciseGif = findViewById(R.id.exerciseGif);
        nextSet = (Button) findViewById(R.id.nextSet);
        bezetButton = (Button) findViewById(R.id.bezetButton);


        workoutName.setText("Oma's Workout");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);


        loaddata();
        ellipt();

    }

    public void ellipt(){
        exerciseName.setText("Elliptical Trainer");
        exerciseGif.setImageResource(R.drawable.mama1);
        repsAmount.setText("10 min");
        setsCount.setText("10 min");
        bezetButton.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.INVISIBLE);

        if (!ellipBezet) {
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            ellipBezet = true;
            seatBic();
        });

        nextSet.setOnClickListener(view ->{

         if (ellipBezet) {
            ellipBezet = false;
            bezet();
        }
        else {
            seatBic();
        }});
    }

    public void seatBic(){
        exerciseName.setText("Seated Bicycle");
        exerciseGif.setImageResource(R.drawable.mama2);
        repsAmount.setText("12x");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.INVISIBLE);
        bezetButton.setVisibility(View.INVISIBLE);
        nextSet.setVisibility(View.VISIBLE);

        if (!seatedBiBezet) {
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            seatedBiBezet = true;
            squat();
        });

        nextSet.setOnClickListener(view -> {
            if (TextUtils.isEmpty(repsInput.getText().toString())) {
                repsInput.setError("Fill in the amount of reps you did");
                return;
            }
            setsCount.setText("2 of 3");


            nextSet.setOnClickListener(view1 -> {
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }
                setsCount.setText("3 of 3");




            nextSet.setOnClickListener(view11 -> {
                if (TextUtils.isEmpty(repsInput.getText().toString())) {
                    repsInput.setError("Fill in the amount of reps you did");
                    return;
                }
                if (seatedBiBezet) {
                    seatedBiBezet = false;
                    bezet();
                }
                else {
                    squat();
                }

            });

            });});}

    public void squat(){
        exerciseName.setText("Squat");
        exerciseGif.setImageResource(R.drawable.mama3);
        repsAmount.setText("10-12x");
        setsCount.setText("1 of 3");
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        bezetButton.setVisibility(View.VISIBLE);
        nextSet.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(squatmax));

        if (!squatBezet) {
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            squatBezet = true;
            treadmill();
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
                weight2 = (float) (weight1 + 1);
            }

            else  if (reps < 10) {
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
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight3 = (float) (weight2 + 1);
            }

            else  if (reps < 10) {
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
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight4 = (float) (weight3 + 1);
            } else if (reps < 10) {
                weight4 = (float) (weight3 - 1);
            } else {
                weight4 = weight3;
            }


            float[] weightArray = {weight1, weight2, weight3, weight4, squatmax};
            squatmax = 0;
            for (float v : weightArray) {
                squatmax = Math.max(squatmax, v);
            }
            if (squatBezet) {
                squatBezet = false;
                bezet();
            }
            else {treadmill();}


        });});});}

    public void treadmill(){
            exerciseName.setText("Treadmill");
            exerciseGif.setImageResource(R.drawable.mama4);
            repsAmount.setText("10 min");
            setsCount.setText("10 min");
            bezetButton.setVisibility(View.INVISIBLE);
            textView6.setVisibility(View.INVISIBLE);
            textView7.setVisibility(View.INVISIBLE);
            repsInput.setVisibility(View.INVISIBLE);
            weightInput.setVisibility(View.INVISIBLE);

            if (!rennenBezet) {
                bezetButton.setVisibility(View.VISIBLE);
            }

            bezetButton.setOnClickListener(view -> {
                rennenBezet = true;
                abs();
            });

            nextSet.setOnClickListener(view -> {
                if (rennenBezet) {
                    rennenBezet = false;
                    bezet();
                }
                else {
                    abs();
                }
            });
        }

        public void abs(){
            exerciseName.setText("Abdominal crunch machine");
            exerciseGif.setImageResource(R.drawable.mama5);
            repsAmount.setText("10-12x");
            setsCount.setText("1 of 3");
            bezetButton.setVisibility(View.INVISIBLE);
            textView6.setVisibility(View.VISIBLE);
            textView7.setVisibility(View.VISIBLE);
            repsInput.setVisibility(View.VISIBLE);
            weightInput.setVisibility(View.VISIBLE);
            weightInput.setText(String.valueOf(absmax));

            if (!absBezet) {
                bezetButton.setVisibility(View.VISIBLE);
            }

            bezetButton.setOnClickListener(view -> {
                absBezet = true;
                lunge();
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
                            weight2 = (float) (weight1 + 1);
                        } else if (reps < 10) {
                            weight2 = (float) (weight1 - 1);
                        } else {
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
                        weight1 = Float.parseFloat(weightString);
                        repsString = String.valueOf(repsInput.getText());
                        reps = Integer.parseInt(repsString);

                        if (reps > 12) {
                            weight3 = (float) (weight2 + 1);
                        } else if (reps < 10) {
                            weight3 = (float) (weight2 - 1);
                        } else {
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
                weight1 = Float.parseFloat(weightString);
                repsString = String.valueOf(repsInput.getText());
                reps = Integer.parseInt(repsString);

                if (reps > 12) {
                    weight4 = (float) (weight3 + 1);
                } else if (reps < 10) {
                    weight4 = (float) (weight3 - 1);
                } else {
                    weight4 = weight3;
                }


                float[] weightArray = {weight1, weight2, weight3, weight4, absmax};
                absmax = 0;
                for (float v : weightArray) {
                    absmax = Math.max(absmax, v);
                }
                if (absBezet) {
                    absBezet = false;
                    bezet();
                }
                else {lunge();}


            });});});
    }

    public void lunge(){
        exerciseName.setText("Lunge alternated");
        exerciseGif.setImageResource(R.drawable.mama6);
        repsAmount.setText("10-12x per kant");
        setsCount.setText("1 of 3");
        bezetButton.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        repsInput.setVisibility(View.VISIBLE);
        weightInput.setVisibility(View.VISIBLE);
        weightInput.setText(String.valueOf(lungemax));

        if (!lungeBezet) {
            bezetButton.setVisibility(View.VISIBLE);
        }

        bezetButton.setOnClickListener(view -> {
            lungeBezet = true;
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

            if (reps > 12) {
                weight2 = (float) (weight1 + 1);
            } else if (reps < 10) {
                weight2 = (float) (weight1 - 1);
            } else {
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
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight3 = (float) (weight2 + 1);
            } else if (reps < 10) {
                weight3 = (float) (weight2 - 1);
            } else {
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
            weight1 = Float.parseFloat(weightString);
            repsString = String.valueOf(repsInput.getText());
            reps = Integer.parseInt(repsString);

            if (reps > 12) {
                weight4 = (float) (weight3 + 1);
            } else if (reps < 10) {
                weight4 = (float) (weight3 - 1);
            } else {
                weight4 = weight3;
            }


            float[] weightArray = {weight1, weight2, weight3, weight4, lungemax};
            lungemax = 0;
            for (float v : weightArray) {
                lungemax = Math.max(lungemax, v);
            }
            if (lungeBezet) {
                lungeBezet = false;
                bezet();
            }
            else {bezet();}


        });});});
    }

    public void fietsen(){
        exerciseName.setText("Fietsen");
        exerciseGif.setImageResource(R.drawable.mama7);
        repsAmount.setText("10 min");
        setsCount.setText("10 min");
        bezetButton.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        repsInput.setVisibility(View.INVISIBLE);
        weightInput.setVisibility(View.INVISIBLE);

        nextSet.setOnClickListener(view -> {
            savedata();
            startActivity(new Intent(workoutMama.this, MainActivity.class));

        });
    }

    public void loaddata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        squatmax = sharedPreferences.getFloat(SQUATMAX, squatmax);
        lungemax = sharedPreferences.getFloat(LUNGEMAX, lungemax);
        absmax = sharedPreferences.getFloat(ABSMAX,absmax);


    }


    public void bezet(){
        if (ellipBezet){
            ellipt();
        }

        else if (seatedBiBezet){
            seatBic();
        }
        else if (squatBezet){
            squat();
        }
        else if(rennenBezet){
            treadmill();
        }
        else if (absBezet){
            abs();
        }
        else if (lungeBezet){
            lunge();
        }


        else if (!ellipBezet && !seatedBiBezet && !squatBezet && !rennenBezet && !absBezet && !lungeBezet) {
            fietsen();
        }}
    public void savedata() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(SQUATMAX, squatmax);
        editor.putFloat(ABSMAX, absmax);
        editor.putFloat(LUNGEMAX, lungemax);


        editor.apply();
    }

}