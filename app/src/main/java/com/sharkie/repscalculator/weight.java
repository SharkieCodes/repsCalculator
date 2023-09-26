package com.sharkie.repscalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.room.Room;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class weight extends AppCompatActivity {

    private EditText weightInputs;
    private EditText fatInput;
    private EditText muscleInput;
    private Button saveButton;
    private TextView displayTextView;
    private List<numberEntity> numbersList;
    private AppDatabase appDatabase;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight);



                // Initialize views
                weightInputs = findViewById(R.id.weightInputs);
                fatInput = findViewById(R.id.fatInput);
                muscleInput = findViewById(R.id.muscleInput);
                saveButton = findViewById(R.id.saveButton);
                displayTextView = findViewById(R.id.displayTextView);

                // Initialize database
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "numbers-database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

                // Laad de vorige nummers
                numbersList = appDatabase.numberDao().getAll();

                // Kijk of de opsla knop ingedrukt wordt
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveNumbers();
                    }
                });


                displayNumbers();
            }

            private void saveNumbers() {
                // Get the entered numbers from the EditText
                float weightNum = Float.parseFloat(weightInputs.getText().toString());
                float fatNum = Float.parseFloat(fatInput.getText().toString());
                float muscleNum = Float.parseFloat(muscleInput.getText().toString());


                numberEntity numberEntity = new numberEntity(weightNum, fatNum, muscleNum);

                appDatabase.numberDao().insert(numberEntity);

                numbersList.add(numberEntity);

                displayNumbers();

                weightInputs.getText().clear();
                fatInput.getText().clear();
                muscleInput.getText().clear();
            }

            private void displayNumbers() {
                StringBuilder builder = new StringBuilder();
                LocalDate currentDate = LocalDate.now();
                String currentDates = currentDate.format(DateTimeFormatter.ofPattern("MM/dd"));
                // alle nummers naar string omzetten



                for (numberEntity number : numbersList) {



                    DecimalFormat df = new DecimalFormat("#.000");

                    float fatNums = number.getFatNum();
                    float weightNums = number.getWeightNum();
                    float muscleNums = number.getMuscleNum();


                    float fatWeight = (fatNums / 100) * weightNums;
                    float muscleWeight = (muscleNums / 100) * weightNums;

                    float fatWeightR = Float.valueOf(df.format(fatWeight));
                    float muscleWeightR = Float.valueOf(df.format(muscleWeight));
                    builder.append(currentDates + "  -  ")
                            .append(weightNums).append("kg ")
                            .append(fatNums).append("% ")
                            .append(muscleNums).append("% ")
                            .append(fatWeightR).append("kg ")
                            .append(muscleWeightR).append("kg")
                            .append("\n");

                }


                displayTextView.setText(builder.toString());
            }
        }
