package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.activities.model.list.*;

import java.io.Serializable;
import java.util.ArrayList;
public class List implements Serializable {
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public double pop;
    public Sys sys;
    public String dt_txt;
    public Rain rain;
}
