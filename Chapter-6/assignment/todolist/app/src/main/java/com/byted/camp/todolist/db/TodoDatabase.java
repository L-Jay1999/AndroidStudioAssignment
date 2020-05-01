package com.byted.camp.todolist.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.beans.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Todo.db";

    private static volatile TodoDatabase sInstance;

    public abstract NoteOperator noteOperator();

    public static TodoDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (TodoDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static TodoDatabase buildDatabase(Context appContext) {
        return Room.databaseBuilder(appContext, TodoDatabase.class, DATABASE_NAME)
//                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();
    }


}
