package com.example.myweatherbase.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.City;
import com.example.myweatherbase.activities.model.Coord;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SelectCity extends BaseActivity implements CallInterface {

    private ImageView ciudad;

    private Spinner spinnerCiudad;

    private Button aceptar;

    private HashMap<String, Coord> ciudades;

    private String[] ciudadesNombre;


    @Override
    public void onCreate(Bundle savedInstaceState){

        super.onCreate(savedInstaceState);

        setContentView(R.layout.select_city);

        ciudad = findViewById(R.id.city);

        spinnerCiudad = findViewById(R.id.spinnerCity);

        aceptar = findViewById(R.id.accept);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ciudades.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudad.setAdapter(adapter);

        spinnerCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                R.
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void doInBackground() {

        ciudades.put(Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163").city.name ,
                Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163").city.coord);

        ciudades.put(Connector.getConector().get(Root.class,"&lat=39.47579838925009&lon=-0.37267699999999904").city.name,
                Connector.getConector().get(Root.class,"&lat=39.47579838925009&lon=-0.37267699999999904").city.coord);

        ciudades.put(Connector.getConector().get(Root.class,"&lat=35.86166000000001&lon=104.19539700000001").city.name,
                Connector.getConector().get(Root.class,"&lat=35.86166000000001&lon=104.19539700000001").city.coord);

        for(String nombre : ciudades.keySet()){

            ciudadesNombre.add

        }

    }

    @Override
    public void doInUI() {

        hideProgress();

    }




}
