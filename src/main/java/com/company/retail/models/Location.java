package com.company.retail.models;

import javax.validation.constraints.NotNull;

/**
 * Request Model to keep latitude & longitude
 * Created by saurav on 29/8/16.
 */
public class Location {
    @NotNull private final Double latitude;
    @NotNull private final Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (latitude != null ? !latitude.equals(location.latitude) : location.latitude != null) return false;
        return longitude != null ? longitude.equals(location.longitude) : location.longitude == null;
    }

    @Override
    public int hashCode() {
        int result = latitude != null ? latitude.hashCode() : 0;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }


    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
