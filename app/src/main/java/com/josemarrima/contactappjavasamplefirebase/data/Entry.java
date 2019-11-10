package com.josemarrima.contactappjavasamplefirebase.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "entry")
public class Entry {

    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String email;
    private String phone;

    @Ignore
    public Entry() {
    }

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
