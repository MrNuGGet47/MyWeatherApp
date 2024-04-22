package com.example.myweatherbase.activities;

import static com.example.myweatherbase.activities.MainActivity.root;

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

public class infoTiempo extends AppCompatActivity {

    private ImageView imageView;
    private TextView descripcion;
    private TextView hora;

    private TextView nombreDia;

    private TextView fecha;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_element);

        List info = (List) getIntent().getExtras().get("INFO");

        imageView = findViewById(R.id.iconInf);

        hora = findViewById(R.id.horaInf);

        descripcion = findViewById(R.id.descripcionInf);

        nombreDia = findViewById(R.id.nombreDiaInf);

        fecha = findViewById(R.id.fechaInf);

        descripcion.setText(info.weather.get(0).description);

        Date date = new Date((long) info.dt * 1000);

        SimpleDateFormat dateDay = new SimpleDateFormat("dd / MM / yyyy");

        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");

        SimpleDateFormat dayName = new SimpleDateFormat("EEEE");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + info.weather.get(0).icon + Parameters.ICON_URL_POST, imageView);

        fecha.setText(dateDay.format(date));

        hora.setText(hour.format(date));

        nombreDia.setText(dayName.format(date));

    }

}
