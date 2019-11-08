package com.josemarrima.contactappjavasamplefirebase.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.josemarrima.contactappjavasamplefirebase.data.Entry;

@Database(entities = {Entry.class}, version = 1, exportSchema = false)
public abstract class EntryDatabase extends RoomDatabase {

    private static final String LOG_TAG = EntryDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "entry_db";
    private static EntryDatabase sInstance;

    public static EntryDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        EntryDatabase.class, EntryDatabase.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract EntryDao entryDao();
}
