package com.vikingz;

import com.badlogic.gdx.Gdx;


public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean filesExist() {
        return Gdx.files.internal(firstName).exists();
    }
}
