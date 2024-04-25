package com.example.myweatherbase.activities;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.CityE;
import com.example.myweatherbase.activities.model.Coord;
import com.example.myweatherbase.base.ThemeSetup;

import java.util.HashMap;
import java.util.List;

import kotlin.Suppress;


public class MainActivity extends AppCompatActivity implements LocationListener{

    private ImageView city;

    private LocationManager managerLoc;

    private Spinner citySpinner;

    private Double lon;

    private Double lat;

    private ImageButton settings;

    private Switch nightMode;

    private Button location;

    private String provider;

    private final int seconds = 10;

    private final float meters = 5;

    @Override
    public void onCreate(Bundle savedInstaceState){

        super.onCreate(savedInstaceState);

        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);

        citySpinner = findViewById(R.id.spinnerCity);

        settings = findViewById(R.id.ajustes);

        nightMode = findViewById(R.id.night);

        location = findViewById(R.id.location);

        managerLoc = (LocationManager) getSystemService(LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        criteria.setCostAllowed(false);

        criteria.setAltitudeRequired(true);

        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        provider = managerLoc.getBestProvider(criteria,true);

        @SuppressLint("MissingPermission")
        Location locationAct = managerLoc.getLastKnownLocation(provider);

        ArrayAdapter<CityE> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CityE.values());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                CityE selectedCity = (CityE) adapterView.getSelectedItem();

                lat = selectedCity.getLat();

                lon = selectedCity.getLon();

                city.setImageResource(selectedCity.getImg());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                lat = 39.5862518;

                lon = -0.5411163;

            }
        });

        nightMode.setOnCheckedChangeListener( (buttonView, isChecked) ->{

            if(isChecked)

                ThemeSetup.applyTheme(ThemeSetup.Mode.DARK);

            else

                ThemeSetup.applyTheme(ThemeSetup.Mode.DEFAULT);

        });

        settings.setOnClickListener(View ->{

            Intent intent = new Intent(this, Preferences.class);

            startActivity(intent);

        });

        location.setOnClickListener(View ->{

            Intent intent = new Intent(this, InfHours.class);

            intent.putExtra("LON",locationAct.getLongitude());

            intent.putExtra("LAT",locationAct.getLatitude());

            startActivity(intent);

        });

    }

    public void accept(View view){

        Intent intent = new Intent(this, InfHours.class);

        intent.putExtra("LON",lon);

        intent.putExtra("LAT", lat);

        startActivity(intent);

    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onResume() {

        super.onResume();

        managerLoc.requestLocationUpdates(provider,seconds*1000,meters,this);

    }

    @Override
    protected void onPause() {

        super.onPause();

        managerLoc.removeUpdates(this);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {


    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

        LocationListener.super.onProviderEnabled(provider);

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

        LocationListener.super.onProviderDisabled(provider);

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Your implementation here
    }


}
