package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;

public enum CityE {
    POBLADEVALLBONA("PoblaDeVallbona", 39.5883, -0.5554624, R.mipmap.ic_lapobla),
    PATERNA("Paterna", 39.5043274, -0.4505384, R.mipmap.ic_paterna),
    PUÇOL("Puçol",39.6182216,-0.3075414, R.mipmap.ic_puzol);

    private String nombre;

    private double lat;

    private double lon;

    private int img;

    CityE(String nombre, double lat, double lon, int img) {

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