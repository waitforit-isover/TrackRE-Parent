package com.sevenre.trackre.parent.datatypes;

public class Child {

    String firstName, lastName, school, id;

    public Child(){}

    public Child(String id, String firstName, String lastName, String school) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchool() {
        return school;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
