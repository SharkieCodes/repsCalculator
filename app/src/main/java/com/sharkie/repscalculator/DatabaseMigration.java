package com.sharkie.repscalculator;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseMigration {
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Perform the necessary migration operations here
            // For example, you can create a new table or alter an existing table
            database.execSQL("ALTER TABLE numbers ADD COLUMN new_column_name INTEGER NOT NULL DEFAULT 0");
        }
    };
}