package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetsEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetsEntry.TABLE_NAME + " (" +
                    PetsEntry._ID + NUMBER_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                    PetsEntry.COLUMN_PET_NAME + TEXT_TYPE + " NOT NULL" + COMMA_SEP +
                    PetsEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
                    PetsEntry.COLUMN_PET_GENDER + NUMBER_TYPE + " NOT NULL" + COMMA_SEP +
                    PetsEntry.COLUMN_PET_WEIGHT + NUMBER_TYPE + " NOT NULL DEFAULT 0" +
                    ");";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
