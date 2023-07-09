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

                // Load previously saved numbers
                numbersList = appDatabase.numberDao().getAll();

                // Set click listener for the save button
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveNumbers();
                    }
                });

                // Display the numbers
                displayNumbers();
            }

            private void saveNumbers() {
                // Get the entered numbers from the EditText
                float weightNum = Float.parseFloat(weightInputs.getText().toString());
                float fatNum = Float.parseFloat(fatInput.getText().toString());
                float muscleNum = Float.parseFloat(muscleInput.getText().toString());

                // Create a new NumberEntity object
                numberEntity numberEntity = new numberEntity(weightNum, fatNum, muscleNum);

                // Insert the numbers into the database
                appDatabase.numberDao().insert(numberEntity);

                // Add the numbers to the list
                numbersList.add(numberEntity);

                // Display the numbers
                displayNumbers();

                // Clear the EditText
                weightInputs.getText().clear();
                fatInput.getText().clear();
                muscleInput.getText().clear();
            }

            private void displayNumbers() {
                StringBuilder builder = new StringBuilder();
                LocalDate currentDate = LocalDate.now();
                String currentDates = currentDate.format(DateTimeFormatter.ofPattern("MM/dd"));
                // Append each set of numbers to the StringBuilder



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

                // Set the TextView text
                displayTextView.setText(builder.toString());
            }
        }
