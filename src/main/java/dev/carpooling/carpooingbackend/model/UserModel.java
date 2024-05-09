package dev.carpooling.carpooingbackend.model;

import dev.carpooling.carpooingbackend.entities.Gender;

public class UserModel {

    private String name;
    private String email;
    private Gender gender;

    public UserModel() {
    }

    public UserModel(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
