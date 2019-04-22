package com.brain.firebasetest;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.ArrayList;

public class Person {
    public String name;

    @Exclude
    public ArrayList<Person> friends = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void saveFriendsToDB(DatabaseReference databaseReference) {
        for (Person friend: friends) {
            databaseReference.child("friends").push().setValue(friend);
        }

    }

}
