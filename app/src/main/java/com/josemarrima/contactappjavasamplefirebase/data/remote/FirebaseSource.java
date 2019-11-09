package com.josemarrima.contactappjavasamplefirebase.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.josemarrima.contactappjavasamplefirebase.data.Entry;

import java.util.ArrayList;


public class FirebaseSource {

    private DatabaseReference databaseReference;
    private ArrayList<Entry> entryArrayList;

    private static final String TAG = "FirebaseSource";

    private void loadEntriesFromFirebase() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("Entry");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                entryArrayList.add(dataSnapshot.getValue(Entry.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled: " + databaseError.toString());
            }
        });
    }

    public MutableLiveData<ArrayList<Entry>> getEntry() {
        loadEntriesFromFirebase();
        MutableLiveData<ArrayList<Entry>> entries = new MutableLiveData<>();
        entries.setValue(entryArrayList);
        return entries;
    }

    public void SaveEntry(String name, String email, String phone) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Entry");
        String id = databaseReference.push().getKey();
        Entry entry = new Entry(id, name, email, phone);
        databaseReference.child(id).setValue(entry);
    }
}
