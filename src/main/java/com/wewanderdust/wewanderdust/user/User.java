package com.wewanderdust.wewanderdust.user;

import java.time.LocalDate;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private String bio;
    private String profilePicture;
    private String location;
    private LocalDate dateOfBirth;
    private LocalDate joinedOn;
    private String[] interests;

    public User() {
    }

    public User(int userId, String name, String email, String password, String role, String bio, String profilePicture, String location, LocalDate dateOfBirth, LocalDate joinedOn, String[] interests) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.joinedOn = joinedOn;
        this.interests = interests;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(LocalDate joinedOn) {
        this.joinedOn = joinedOn;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", bio='" + bio + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", location='" + location + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", joinedOn='" + joinedOn + '\'' +
                ", interests='" + interests + '\'' +
                '}';
    }
}
