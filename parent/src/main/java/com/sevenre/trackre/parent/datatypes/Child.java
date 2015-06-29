package com.sevenre.trackre.parent.datatypes;

public class Child {

    String firstName, lastName, school;
    boolean isDetailView = false;

    public Child(){}

    public Child(String firstName, String lastName, String school) {
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

    public boolean isDetailView() {
        return isDetailView;
    }

    public void setIsDetailView(boolean isDetailView) {
        this.isDetailView = isDetailView;
    }
}
