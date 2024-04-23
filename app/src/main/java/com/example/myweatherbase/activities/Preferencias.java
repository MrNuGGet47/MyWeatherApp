package com.example.myweatherbase.activities;

import static java.util.List.of;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.base.Parameters;

import java.util.Arrays;
import java.util.List;

public class Preferencias extends AppCompatActivity {

    private EditText api;

    private Spinner units;

    private Spinner language;

    private Spinner theme;



    @Override
    public void onCreate(Bundle savedInstance){

        super.onCreate(savedInstance);

        api = findViewById(R.id.api);

        units = findViewById(R.id.units);

        language = findViewById(R.id.language);

        theme = findViewById(R.id.theme);

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, new String[]{"metric","imperial"});

        units.setAdapter(unitsAdapter);

        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"es","en"});

        language.setAdapter(languageAdapter);


    }
    public void aceptar(View view){

        Parameters.LANG = language.getSelectedItem().toString();

        Parameters.UNITS = units.getSelectedItem().toString();

        Intent intent = new Intent();

        setResult(RESULT_OK, intent);

        finish();

    }
    public void cancelar(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }



}
