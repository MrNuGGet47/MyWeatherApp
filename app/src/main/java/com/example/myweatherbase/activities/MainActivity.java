package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity implements CallInterface , View.OnClickListener{

    private TextView txtView ;

    private TextView textViewDay;

    private TextView textViewDayOfWeek;

    private ImageView imageView;

    static Root root;

    private RecyclerView recyclerVW;

    AdaptadorRecyclerVW adaptador;

    private TextView nombreCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerVW = findViewById(R.id.recyclerVW);

        adaptador = new AdaptadorRecyclerVW(this);

        adaptador.setOnClickListener(this);

        recyclerVW.setAdapter(adaptador);

        recyclerVW.setLayoutManager(new LinearLayoutManager(this));

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();

        executeCall(this);
    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {

        root = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163");

    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {

        hideProgress();

    }

    @Override
    public void onClick(View view) {

        List info = root.list.get(recyclerVW.getChildAdapterPosition(view));

        Intent intent = new Intent(this, infoTiempo.class);

        intent.putExtra("INFO",info);

        startActivity(intent);

    }
}