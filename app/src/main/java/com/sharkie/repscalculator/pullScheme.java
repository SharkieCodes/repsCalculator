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
public class pullScheme extends AppCompatActivity {

        public TextView workoutName, exerciseName, repsAmount, setsCount, textView6, textView7;
        public EditText repsInput, weightInput;
        public Button nextExercise, nextSet;
        public GifImageView exerciseGif;
        public String weightString, repsString;
        public float weight1, weight2, weight3,weight4, weight5, latmax, rowmax, horrowmax, bentrowmax, bentflymax, curlmax, incmax, preachmax, shrugmax;
        public int reps;


        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String LATMAX = "latmax";
        public static final String ROWMAX = "rowmax";
        public static final String HORROWMAX = "horrowmax";
        public static final String BENTROWMAX = "bentrowmax";
        public static final String BENTFLYMAX = "bentflymax";
        public static final String CURLMAX =  "curlmax";
        public static final String INCMAX = "incmax";
        public static final String PREACHMAX = "preachmax";
        public static final String SHRUGMAX = "shrugmax";


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


                workoutName.setText("Pull Workout");
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                repsInput.setVisibility(View.VISIBLE);
                weightInput.setVisibility(View.VISIBLE);
                nextExercise.setVisibility(View.INVISIBLE);



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

                nextSet.setOnClickListener(view -> latPulldown());

        }

        public void latPulldown(){
                exerciseName.setText("Lat pulldown wide grip");
                exerciseGif.setImageResource(R.drawable.latpulldown);
                repsAmount.setText("10-12");
                setsCount.setText("1 of 3");
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                repsInput.setVisibility(View.VISIBLE);
                weightInput.setVisibility(View.VISIBLE);
                nextExercise.setVisibility(View.INVISIBLE);
                nextSet.setVisibility(View.VISIBLE);
                weightInput.setText(String.valueOf(latmax));
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

                                else if (reps < 10) {
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

                                        else if (reps < 10) {
                                                weight4 = (float) (weight3 - 2.5);
                                        }
                                        else{
                                                weight4 = weight3;
                                        }




                                                        float[] weightArray = {weight1, weight2, weight3, weight4, latmax};
                                                        latmax = 0;
                                                        for (float v : weightArray) {
                                                                latmax = Math.max(latmax, v);
                                                        }
                                                        row();



                                        });

                                });
                        });
                };

                        public void row(){
                                exerciseName.setText("Row - pulley machine");
                                exerciseGif.setImageResource(R.drawable.rowweight);
                                repsAmount.setText("10-12");
                                setsCount.setText("1 of 3");
                                textView6.setVisibility(View.VISIBLE);
                                textView7.setVisibility(View.VISIBLE);
                                repsInput.setVisibility(View.VISIBLE);
                                weightInput.setVisibility(View.VISIBLE);
                                nextExercise.setVisibility(View.INVISIBLE);
                                nextSet.setVisibility(View.VISIBLE);
                                weightInput.setText(String.valueOf(rowmax));
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

                                                else  if (reps < 10 && weight2 <= 10){
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




                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, rowmax};
                                                                        rowmax = 0;
                                                                        for (float v : weightArray) {
                                                                                rowmax = Math.max(rowmax, v);
                                                                        }
                                                                        horRow();




                                                        });

                                                });
                                        });
                };

                        public void horRow(){
                                exerciseName.setText("Horizontal row machine");
                                exerciseGif.setImageResource(R.drawable.horizontalrow);
                                repsAmount.setText("10-12");
                                setsCount.setText("1 of 3");
                                textView6.setVisibility(View.VISIBLE);
                                textView7.setVisibility(View.VISIBLE);
                                repsInput.setVisibility(View.VISIBLE);
                                weightInput.setVisibility(View.VISIBLE);
                                nextExercise.setVisibility(View.INVISIBLE);
                                nextSet.setVisibility(View.VISIBLE);
                                weightInput.setText(String.valueOf(horrowmax));
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

                                        else  if (reps < 10) {
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


                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, horrowmax};
                                                                        horrowmax = 0;
                                                                        for (float v : weightArray) {
                                                                                horrowmax = Math.max(horrowmax, v);
                                                                        }
                                                                        bentRow();



                                                        });

                                                });
                                        });
                };

                        public void bentRow(){
                                exerciseName.setText("Bent-over row");
                                exerciseGif.setImageResource(R.drawable.bentoverrow);
                                repsAmount.setText("10-12");
                                setsCount.setText("1 of 3");
                                textView6.setVisibility(View.VISIBLE);
                                textView7.setVisibility(View.VISIBLE);
                                repsInput.setVisibility(View.VISIBLE);
                                weightInput.setVisibility(View.VISIBLE);
                                nextExercise.setVisibility(View.INVISIBLE);
                                nextSet.setVisibility(View.VISIBLE);
                                weightInput.setText(String.valueOf(bentrowmax));
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

                                                else   if (reps > 12 && weight2 <10){
                                                        weight3 = (float) (weight2 + 1);
                                                }

                                                else  if (reps < 10 && weight2 <= 10){
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




                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, bentrowmax};
                                                                        bentrowmax = 0;
                                                                        for (float v : weightArray) {
                                                                                bentrowmax = Math.max(bentrowmax, v);
                                                                        }
                                                                        bentFly();



                                                        });

                                                });
                                        });
                                };


                                public void bentFly(){
                                        exerciseName.setText("Bent-over reverse fly");
                                        exerciseGif.setImageResource(R.drawable.reversefly);
                                        repsAmount.setText("10-12");
                                        setsCount.setText("1 of 3");
                                        textView6.setVisibility(View.VISIBLE);
                                        textView7.setVisibility(View.VISIBLE);
                                        repsInput.setVisibility(View.VISIBLE);
                                        weightInput.setVisibility(View.VISIBLE);
                                        nextExercise.setVisibility(View.INVISIBLE);
                                        nextSet.setVisibility(View.VISIBLE);
                                        weightInput.setText(String.valueOf(bentflymax));
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

                                                else  if (reps < 10) {
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

                                                                else   if (reps < 10) {
                                                                        weight4 = (float) (weight3 - 5);
                                                                }
                                                                else {
                                                                        weight4 = weight3;
                                                                }




                                                                                float[] weightArray = {weight1, weight2, weight3, weight4, bentflymax};
                                                                                bentflymax = 0;
                                                                                for (float v : weightArray) {
                                                                                        bentflymax = Math.max(bentflymax, v);
                                                                                }
                                                                                bicepCurl();



                                                                });

                                                        });
                                                });
                                        };
                                        public void bicepCurl(){
                                                exerciseName.setText("Bicep curl");
                                                exerciseGif.setImageResource(R.drawable.bicepcurl);
                                                repsAmount.setText("10-12");
                                                setsCount.setText("1 of 3");
                                                textView6.setVisibility(View.VISIBLE);
                                                textView7.setVisibility(View.VISIBLE);
                                                repsInput.setVisibility(View.VISIBLE);
                                                weightInput.setVisibility(View.VISIBLE);
                                                nextExercise.setVisibility(View.INVISIBLE);
                                                nextSet.setVisibility(View.VISIBLE);
                                                weightInput.setText(String.valueOf(curlmax));
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

                                                                else  if (reps < 10 && weight2 >=12) {
                                                                        weight3 = (float) (weight2 - 2);
                                                                }

                                                                else  if (reps > 12 && weight2 <10){
                                                                        weight3 = (float) (weight2 + 1);
                                                                }

                                                                else if (reps < 10 && weight2 <= 10){
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

                                                                        else if (reps < 10 && weight3 >=12) {
                                                                                weight4 = (float) (weight3 - 2);
                                                                        }

                                                                        else  if (reps > 12 && weight3 <10){
                                                                                weight4 = (float) (weight3 + 1);
                                                                        }

                                                                        else   if (reps < 10 && weight3 <= 10){
                                                                                weight4 = (float) (weight3 - 1);
                                                                        }
                                                                        else {
                                                                                weight4 = weight3;
                                                                        }



                                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, curlmax};
                                                                                        curlmax = 0;
                                                                                        for (float v : weightArray) {
                                                                                                curlmax = Math.max(curlmax, v);
                                                                                        }
                                                                                        inclineCurl();



                                                                        });

                                                                });
                                                        });
                                };
                                        public void inclineCurl(){
                                                exerciseName.setText("Incline curl");
                                                exerciseGif.setImageResource(R.drawable.inclinedbcurl);
                                                repsAmount.setText("10-12");
                                                setsCount.setText("1 of 3");
                                                textView6.setVisibility(View.VISIBLE);
                                                textView7.setVisibility(View.VISIBLE);
                                                repsInput.setVisibility(View.VISIBLE);
                                                weightInput.setVisibility(View.VISIBLE);
                                                nextExercise.setVisibility(View.INVISIBLE);
                                                nextSet.setVisibility(View.VISIBLE);
                                                weightInput.setText(String.valueOf(incmax));
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

                                                                else  if (reps < 10 && weight2 >=12) {
                                                                        weight3 = (float) (weight2 - 2);
                                                                }

                                                                else  if (reps > 12 && weight2 <10){
                                                                        weight3 = (float) (weight2 + 1);
                                                                }

                                                                else  if (reps < 10 && weight2 <= 10){
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

                                                                        else if (reps < 10 && weight3 >=12) {
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




                                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, incmax};
                                                                                        incmax = 0;
                                                                                        for (float v : weightArray) {
                                                                                                incmax = Math.max(incmax, v);
                                                                                        }
                                                                                        preach();



                                                                        });

                                                                });
                                                        });
                                };
                                        public void preach(){
                                                exerciseName.setText("Preacher curl");
                                                exerciseGif.setImageResource(R.drawable.preachercurl);
                                                repsAmount.setText("10-12");
                                                setsCount.setText("1 of 3");
                                                textView6.setVisibility(View.VISIBLE);
                                                textView7.setVisibility(View.VISIBLE);
                                                repsInput.setVisibility(View.VISIBLE);
                                                weightInput.setVisibility(View.VISIBLE);
                                                nextExercise.setVisibility(View.INVISIBLE);
                                                nextSet.setVisibility(View.VISIBLE);
                                                weightInput.setText(String.valueOf(preachmax));
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

                                                                else   if (reps < 10) {
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




                                                                                        float[] weightArray = {weight1, weight2, weight3, weight4, weight5, preachmax};
                                                                                        preachmax = 0;
                                                                                        for (float v : weightArray) {
                                                                                                preachmax = Math.max(preachmax, v);
                                                                                        }
                                                                                        shrugs();



                                                                        });

                                                                });
                                                        });
                                };

        public void shrugs(){
                exerciseName.setText("Shrugs");
                exerciseGif.setImageResource(R.drawable.shrugs);
                repsAmount.setText("10-12");
                setsCount.setText("1 of 3");
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                repsInput.setVisibility(View.VISIBLE);
                weightInput.setVisibility(View.VISIBLE);
                nextExercise.setVisibility(View.INVISIBLE);
                nextSet.setVisibility(View.VISIBLE);
                weightInput.setText(String.valueOf(shrugmax));
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

                                else  if (reps < 10 && weight2 >=12) {
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

                                        else  if (reps > 12 && weight3 <10){
                                                weight4 = (float) (weight3 + 1);
                                        }

                                        else  if (reps < 10 && weight3 <= 10){
                                                weight4 = (float) (weight3 - 1);
                                        }
                                        else {
                                                weight4 = weight3;
                                        }




                                                        float[] weightArray = {weight1, weight2, weight3, weight4, weight5, shrugmax};
                                                        shrugmax = 0;
                                                        for (float v : weightArray) {
                                                                shrugmax = Math.max(shrugmax, v);
                                                        }
                                                        running();



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

                                                nextSet.setOnClickListener(view -> {
                                                        savedata();
                                                        startActivity(new Intent(pullScheme.this, MainActivity.class));

                                                });
                                        }


        public void savedata() {
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putFloat(LATMAX, latmax);
                        editor.putFloat(ROWMAX, rowmax);
                        editor.putFloat(HORROWMAX, horrowmax);
                        editor.putFloat(BENTROWMAX, bentrowmax);
                        editor.putFloat(BENTFLYMAX, bentflymax);
                        editor.putFloat(CURLMAX, curlmax);
                        editor.putFloat(INCMAX, incmax);
                        editor.putFloat(PREACHMAX, preachmax);
                        editor.putFloat(SHRUGMAX,shrugmax);

                        editor.apply();
                }

                public void loaddata(){
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        latmax = sharedPreferences.getFloat(LATMAX, latmax);
                        rowmax = sharedPreferences.getFloat(ROWMAX,rowmax);
                        horrowmax = sharedPreferences.getFloat(HORROWMAX,horrowmax);
                        bentrowmax = sharedPreferences.getFloat(BENTROWMAX,bentrowmax);
                        bentflymax = sharedPreferences.getFloat(BENTFLYMAX,bentflymax);
                        curlmax = sharedPreferences.getFloat(CURLMAX, curlmax);
                        incmax = sharedPreferences.getFloat(INCMAX,incmax);
                        preachmax = sharedPreferences.getFloat(PREACHMAX,preachmax);
                        shrugmax = sharedPreferences.getFloat(SHRUGMAX,shrugmax);

                }
        }