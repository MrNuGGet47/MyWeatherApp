package com.example.myweatherbase.base;

public class Parameters {

    public static String API = "b95c419ac74528f1ee41a44b01d7fd21";
    public static String LANG = "es";
    public static String UNITS = "metric";
    public final static String URL = "https://api.openweathermap.org/data/2.5/";
    public  static String URL_OPTIONS =   "forecast?appid=" + API + "&lang=" + LANG + "&units=" + UNITS;

    public final static String ICON_URL_PRE = "http://openweathermap.org/img/wn/";
    public static final String ICON_URL_POST = "@2x.png";

    public static void setLANG(String lang){

        LANG = lang;

        URL_OPTIONS = "forecast?appid=" + API + "&lang=" + LANG + "&units=" + UNITS;

    }

    public static void setUNITS(String units){

        UNITS = units;

        URL_OPTIONS = "forecast?appid=" + API + "&lang=" + LANG + "&units=" + UNITS;

    }


}
