package com.sharkie.repscalculator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "numbers")
public class numberEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int weightNum;
    private int fatNum;
    private int muscleNum;

    public numberEntity(int weightNum, int fatNum, int muscleNum) {
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

    public int getWeightNum() {
        return weightNum;
    }

    public void setWeightNum(int weightNum) {
        this.weightNum = weightNum;
    }

    public int getFatNum() {
        return fatNum;
    }

    public void setFatNum(int fatNum) {
        this.fatNum = fatNum;
    }

    public int getMuscleNum() {
        return muscleNum;
    }

    public void setMuscleNum(int muscleNum) {
        this.muscleNum = muscleNum;
    }
}

