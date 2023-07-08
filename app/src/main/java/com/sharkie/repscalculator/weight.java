package com.sharkie.repscalculator;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.room.Room;
import java.util.List;


public class weight extends AppCompatActivity {

    private EditText weightInputs;
    private EditText fatInput;
    private EditText muscleInput;
    private Button saveButton;
    private TextView displayTextView;
    private List<numberEntity> numbersList;
    private AppDatabase appDatabase;
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.weight);

                // Initialize views
                weightInputs = findViewById(R.id.weightInputs);
                fatInput = findViewById(R.id.fatInput);
                muscleInput = findViewById(R.id.muscleInput);
                saveButton = findViewById(R.id.saveButton);
                displayTextView = findViewById(R.id.displayTextView);

                // Initialize database
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "numbers-database")
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
                int weightNum = Integer.parseInt(weightInputs.getText().toString());
                int fatNum = Integer.parseInt(fatInput.getText().toString());
                int muscleNum = Integer.parseInt(muscleInput.getText().toString());

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

                // Append each set of numbers to the StringBuilder
                for (numberEntity number : numbersList) {
                    builder.append("Number 1: ").append(number.getWeightNum())
                            .append(", Number 2: ").append(number.getFatNum())
                            .append(", Number 3: ").append(number.getMuscleNum())
                            .append("\n");
                }

                // Set the TextView text
                displayTextView.setText(builder.toString());
            }
        }
