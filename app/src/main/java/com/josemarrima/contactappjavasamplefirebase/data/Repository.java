package com.josemarrima.contactappjavasamplefirebase.data;

import androidx.lifecycle.LiveData;

import com.josemarrima.contactappjavasamplefirebase.data.remote.FirebaseSource;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    FirebaseSource firebaseSource = new FirebaseSource();

    public LiveData<List<Entry>> getEntry() {
        return firebaseSource.getEntry();
    }

    public void SaveEntry(String name, String email, String phone) {
        firebaseSource.SaveEntry(name, email, phone);
    }
}
