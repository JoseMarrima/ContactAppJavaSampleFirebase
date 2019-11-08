package com.josemarrima.contactappjavasamplefirebase.data;

import androidx.room.Entity;

@Entity(tableName = "entry")
public class Entry {

    String id;
    String name;
    String email;
    String phone;

    public Entry(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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
