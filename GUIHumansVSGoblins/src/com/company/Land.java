package com.company;

public class Land {
    private int latitude = 10;
    private int longitude = 10;

    public int getLatitude() {return latitude;}
    public int getLongitude() {return longitude;}
    public int[] getLatLong(){
        int[] latLong = new int[2];
        latLong[0] = longitude;
        latLong[1] = latitude;
        return latLong;
    }

}
