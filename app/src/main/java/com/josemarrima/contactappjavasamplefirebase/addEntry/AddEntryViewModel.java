package com.josemarrima.contactappjavasamplefirebase.addEntry;

import androidx.lifecycle.ViewModel;

import com.josemarrima.contactappjavasamplefirebase.data.Repository;

public class AddEntryViewModel extends ViewModel {

    Repository repository = new Repository();

    public void saveEntry(String name, String email, String phone) {
        repository.SaveEntry(name, email, phone);
    }
}
