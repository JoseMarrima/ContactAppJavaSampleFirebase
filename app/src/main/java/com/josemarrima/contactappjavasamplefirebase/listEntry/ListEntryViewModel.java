package com.josemarrima.contactappjavasamplefirebase.listEntry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.josemarrima.contactappjavasamplefirebase.data.Entry;
import com.josemarrima.contactappjavasamplefirebase.data.Repository;

import java.util.ArrayList;
import java.util.List;

public class ListEntryViewModel extends ViewModel {

    Repository repository = new Repository();

    public LiveData<List<Entry>> getEntry() {
        return repository.getEntry();
    }
}
