package com.josemarrima.contactappjavasamplefirebase.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.josemarrima.contactappjavasamplefirebase.data.Entry;

import java.util.List;

@Dao
public interface EntryDao {
    @Query("SELECT * FROM entry")
    LiveData<List<Entry>> loadAllEntries();

    @Insert
    void insertEntry(Entry entry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEntry(Entry entry);

    @Query("SELECT * FROM entry WHERE id = :id")
    LiveData<Entry> loadEntryById(int id);
}
