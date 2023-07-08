package com.sharkie.repscalculator;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NumberDao {
    @Query("SELECT * FROM numbers")
    List<numberEntity> getAll();

    @Insert
    void insert(numberEntity number);

    @Delete
    void delete(numberEntity number);
}
