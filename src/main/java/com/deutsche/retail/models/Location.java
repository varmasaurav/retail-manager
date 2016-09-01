package com.deutsche.retail.models;

/**
 * Request Model to keep latitude & longitude
 * Created by saurav on 29/8/16.
 */
public class Location {
    private final String latitude;
    private final String longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
