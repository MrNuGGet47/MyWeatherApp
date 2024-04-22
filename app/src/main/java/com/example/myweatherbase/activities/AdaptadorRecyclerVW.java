package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;

import java.util.ArrayList;

public class AdaptadorRecyclerVW extends RecyclerView.Adapter<AdaptadorRecyclerVW.ViewHolder> {

    private LayoutInflater layoutInflater;

    private ArrayList<List> periodos;

    private View.OnClickListener;

    public  AdaptadorRecyclerVW(Context context){

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.periodos = Connector.getConector().get(Root.class,"&lat=39.5862518&lon=-0.5411163").list;

    }

    @NonNull
    @Override
    public AdaptadorRecyclerVW.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = layoutInflater.inflate(R.layout.list_simple_element ,parent, false);

        view.setOnClickListener(onClickListener);

        return new ViewHolder(view);

    }

    public void setOnClickListener(View.onClickListener onClickListener){

        this.onClickListener = onClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerVW.ViewHolder holder , int position){

        List periodo = periodos.get(position);

        holder.icono.setText(periodo.weather.get(0).icon);

        holder.dia.setText(periodo.dt_txt.split(" ")[0]);

        holder.precipitacion.setText(periodo.weather.get(0).description);

        holder.fecha.setText(periodo.dt);

        holder.fecha.setText(periodo.dt_txt.split(" ")[1]);



    }

    @Override
    public int getItemCount(){

        return periodos.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView dia, fecha, hora, precipitacion, temperatura, maxima , minima, icono;
        public ViewHolder(@NonNull View itemView){

            super(itemView);

            icono = itemView.findViewById(R.id.icon);

            dia = itemView.findViewById(R.id.dia);

            fecha = itemView.findViewById(R.id.fecha);

            hora = itemView.findViewById(R.id.hora);

            temperatura = itemView.findViewById(R.id.temp);

            maxima = itemView.findViewById(R.id.maxima);

            minima = itemView.findViewById(R.id.minima);

            precipitacion = itemView.findViewById(R.id.precipitacion);

        }
    }
}
