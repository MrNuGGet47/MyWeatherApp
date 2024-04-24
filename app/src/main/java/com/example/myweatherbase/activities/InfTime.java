package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfTime extends AppCompatActivity {

    private ImageView imageView;
    private TextView description;
    private TextView hour;

    private TextView dayName;

    private TextView date;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_element);

        List info = (List) getIntent().getExtras().get("INFO");

        imageView = findViewById(R.id.iconInf);

        hour = findViewById(R.id.horaInf);

        description = findViewById(R.id.descripcionInf);

        dayName = findViewById(R.id.nombreDiaInf);

        date = findViewById(R.id.fechaInf);

        description.setText(info.weather.get(0).description);

        Date date = new Date((long) info.dt * 1000);

        SimpleDateFormat dateDay = new SimpleDateFormat("dd / MM / yyyy");

        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");

        SimpleDateFormat dayName = new SimpleDateFormat("EEEE");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + info.weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        this.date.setText(dateDay.format(date));

        this.hour.setText(hour.format(date));

        this.dayName.setText(dayName.format(date));

    }

}
