package com.example.myweatherbase.activities;

import static java.util.List.of;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.base.Parameters;

public class Preferences extends AppCompatActivity {

    private EditText api;

    private Spinner units;

    private Spinner language;

    @Override
    public void onCreate(Bundle savedInstance){

        super.onCreate(savedInstance);

        setContentView(R.layout.preferences);

        api = findViewById(R.id.api);

        units = findViewById(R.id.units);

        language = findViewById(R.id.language);

        api.setText(Parameters.API);

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, new String[]{"metric","imperial"});

        units.setAdapter(unitsAdapter);

        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"es","en"});

        language.setAdapter(languageAdapter);


    }
    public void apply(View view){

        Parameters.setUNITS(units.getSelectedItem().toString());

        Parameters.setLANG(language.getSelectedItem().toString());

        Parameters.setAPI(language.getSelectedItem().toString());

        finish();

    }
    public void cancel(View view){

        finish();

    }



}
