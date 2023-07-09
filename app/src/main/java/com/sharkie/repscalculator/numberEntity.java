package com.sharkie.repscalculator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "numbers")
public class numberEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private float weightNum;
    private float fatNum;
    private float muscleNum;

    public numberEntity(float weightNum, float fatNum, float muscleNum) {
        this.weightNum = weightNum;
        this.fatNum = fatNum;
        this.muscleNum = muscleNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeightNum() {
        return weightNum;
    }

    public void setWeightNum(float weightNum) {
        this.weightNum = weightNum;
    }

    public float getFatNum() {
        return fatNum;
    }

    public void setFatNum(float fatNum) {
        this.fatNum = fatNum;
    }

    public float getMuscleNum() {
        return muscleNum;
    }

    public void setMuscleNum(float muscleNum) {
        this.muscleNum = muscleNum;
    }
}

