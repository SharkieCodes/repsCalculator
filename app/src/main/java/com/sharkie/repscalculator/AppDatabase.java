package com.sharkie.repscalculator;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {numberEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NumberDao numberDao();
}