package com.expaorbit.interviewproject.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by kajal on 7/20/2020.
 */
@Database(entities = { Employee.class }, version = 1, exportSchema = false)
public abstract class EmpDatabase extends RoomDatabase {

    public abstract EmpDAO empDAO();
    private static EmpDatabase empDatabase;

    public static EmpDatabase getInstance(Context context) {
        if (empDatabase == null) {
            empDatabase = buildDatabaseInstance(context);
        }
        return empDatabase;
    }

    private static EmpDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                EmpDatabase.class,
                "EmpDatabase")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        empDatabase = null;
    }

}
