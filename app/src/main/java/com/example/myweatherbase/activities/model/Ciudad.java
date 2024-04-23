package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;

public enum Ciudad {
    POBLADEVALLBONA("PoblaDeVallbona", 39.5883, -0.5554624, R.mipmap.ic_lapobla),
    PATERNA("Paterna", 39.5043274, -0.4505384, R.mipmap.ic_paterna);

    private String nombre;

    private double lat;

    private double lon;

    private int img;

    Ciudad(String nombre, double lat, double lon, int img) {

        this.nombre = nombre;

        this.lat = lat;

        this.lon = lon;

        this.img = img;

    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getImg() {

        return img;

    }

    @Override
    public String toString(){

        return nombre;

    }
}