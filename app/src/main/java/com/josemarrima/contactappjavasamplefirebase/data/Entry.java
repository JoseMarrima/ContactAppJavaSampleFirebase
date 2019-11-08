package com.josemarrima.contactappjavasamplefirebase.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entry")
public class Entry {

    @NonNull
    @PrimaryKey
    String id;
    String name;
    String email;
    String phone;

    public Entry(@NonNull String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
