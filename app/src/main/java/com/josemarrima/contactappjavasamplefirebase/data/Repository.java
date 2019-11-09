package com.josemarrima.contactappjavasamplefirebase.data;

import com.josemarrima.contactappjavasamplefirebase.data.remote.FirebaseSource;

public class Repository {

    FirebaseSource firebaseSource = new FirebaseSource();

    public void SaveEntry(String name, String email, String phone) {
        firebaseSource.SaveEntry(name, email, phone);
    }
}
