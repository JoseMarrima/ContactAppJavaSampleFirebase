package com.josemarrima.contactappjavasamplefirebase.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.josemarrima.contactappjavasamplefirebase.data.Entry;

import java.util.ArrayList;
import java.util.List;


public class FirebaseSource {

    private DatabaseReference databaseReference;
    private static final String TAG = "FirebaseSource";

    private MutableLiveData<List<Entry>> entries =new MutableLiveData<>();

    public LiveData<List<Entry>> getEntry() {
        if (entries.getValue() == null) {
            FirebaseDatabase.getInstance()
                    .getReference("Entry")
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                entries.postValue(toEntries(dataSnapshot));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e(TAG, "onCancelled database: " + databaseError.getMessage());
                        }
                    });
        }

        return entries;
    }

    private List<Entry> toEntries(DataSnapshot dataSnapshot) {
        List<Entry> entries = new ArrayList<>();
        for (DataSnapshot data: dataSnapshot.getChildren()) {
            Entry entry = data.getValue(Entry.class);
            entries.add(entry);
        }
        Log.d(TAG, "toEntries: " + entries.toString());
        return entries;
    }


    public void SaveEntry(String name, String email, String phone) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Entry");
        String id = databaseReference.push().getKey();
        Entry entry = new Entry(id, name, email, phone);
        databaseReference.child(id).setValue(entry);
    }
}
