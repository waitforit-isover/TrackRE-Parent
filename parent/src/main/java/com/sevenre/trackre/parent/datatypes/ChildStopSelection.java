package com.sevenre.trackre.parent.datatypes;

import java.util.List;

public class ChildStopSelection {

    Child child;
    String selectedStopId;
    String selectedStopName;
    String selectedTripId;
    String selectedTripName;
    int tripType;

    List<Stop> stopList;
    List<Trip> tripList;

    public ChildStopSelection(Child child, String selectedStopId, String selectedStopName, String selectedTripId, String selectedTripName, int tripType) {
        this.child = child;
        this.selectedStopId = selectedStopId;
        this.selectedStopName = selectedStopName;
        this.selectedTripId = selectedTripId;
        this.selectedTripName = selectedTripName;
        this.tripType = tripType;
    }

    public ChildStopSelection(Child child, String selectedStopId, String selectedStopName, String selectedTripId, String selectedTripName, int tripType, List<Stop> stopList, List<Trip> tripList) {
        this.child = child;
        this.selectedStopId = selectedStopId;
        this.selectedStopName = selectedStopName;
        this.selectedTripId = selectedTripId;
        this.selectedTripName = selectedTripName;
        this.tripType = tripType;
        this.stopList = stopList;
        this.tripList = tripList;
    }

    public List<Stop> getStopList() {
        return stopList;
    }

    public void setStopList(List<Stop> stopList) {
        this.stopList = stopList;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public String getChildName () {
        return child.getFirstName() + " " + child.getLastName();
    }

    public String getChildId () {
        return child.getId();
    }

    public int getTripType () {
        return tripType;
    }
}