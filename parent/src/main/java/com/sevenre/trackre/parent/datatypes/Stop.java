package com.sevenre.trackre.parent.datatypes;

public class Stop {

    String name, time, lat, lng, isArrived;

    public Stop(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getIsArrived() {
        return isArrived;
    }

    public void setIsArrived(String isArrived) {
        this.isArrived = isArrived;
    }
}
