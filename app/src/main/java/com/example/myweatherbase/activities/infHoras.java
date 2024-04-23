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

public class infHoras extends BaseActivity implements CallInterface , View.OnClickListener{


    static Root root;

    private RecyclerView recyclerVW;

    AdaptadorRecyclerVW adaptador;

    private TextView nombreCiudad;

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.inf_recycler);

        extras = getIntent().getExtras();

        recyclerVW = findViewById(R.id.recyclerVW);

        nombreCiudad = findViewById(R.id.nombreCiudad);

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

        root = Connector.getConector().get(Root.class,"&lat="+ extras.getDouble("LAT") +"&lon="+ extras.getDouble("LON") + "");

        nombreCiudad.setText(root.city.name);

    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {

        hideProgress();

//        recyclerVW.addItemDecoration();

    }

    @Override
    public void onClick(View view) {

        List info = root.list.get(recyclerVW.getChildAdapterPosition(view));

        Intent intent = new Intent(this, infoTiempo.class);

        intent.putExtra("INFO",info);

        startActivity(intent);

    }
}