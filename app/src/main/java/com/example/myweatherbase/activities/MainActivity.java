package com.example.myweatherbase.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Ciudad;
import com.example.myweatherbase.activities.model.Coord;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.Parameters;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ImageView ciudad;

    private Spinner spinnerCiudad;

    private Button aceptar;

    private HashMap<String, Coord> ciudades;

    private Double lon;

    private Double lat;

    private int img;

    private ImageButton ajustes;

    @Override
    public void onCreate(Bundle savedInstaceState){

        super.onCreate(savedInstaceState);

        setContentView(R.layout.activity_main);

        ciudad = findViewById(R.id.city);

        spinnerCiudad = findViewById(R.id.spinnerCity);

        aceptar = findViewById(R.id.accept);

        ajustes = findViewById(R.id.ajustes);

        ArrayAdapter<Ciudad> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Ciudad.values());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCiudad.setAdapter(adapter);

        spinnerCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Ciudad ciudadElegida = (Ciudad) adapterView.getSelectedItem();

                lat = ciudadElegida.getLat();

                lon = ciudadElegida.getLon();

                ciudad.setImageResource(ciudadElegida.getImg());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                lat = 39.5862518;

                lon = -0.5411163;

            }
        });

        aceptar.setOnClickListener( View ->{

            Intent intent = new Intent(this, infHoras.class);

            intent.putExtra("LON",lon);

            intent.putExtra("LAT", lat);

            startActivity(intent);

        });

        ajustes.setOnClickListener( View ->{

            Intent intent = new Intent(this, Preferencias.class);

            startActivity(intent);

        });


    }





}
