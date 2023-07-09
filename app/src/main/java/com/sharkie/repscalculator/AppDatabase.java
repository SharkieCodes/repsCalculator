package com.sharkie.repscalculator;

import androidx.room.Database;
import androidx.room.RoomDatabase;



@Database(entities = {numberEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NumberDao numberDao();
}