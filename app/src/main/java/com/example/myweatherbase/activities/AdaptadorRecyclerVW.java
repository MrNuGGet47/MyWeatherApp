package com.example.myweatherbase.activities;

import static com.example.myweatherbase.activities.infHoras.root;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdaptadorRecyclerVW extends RecyclerView.Adapter<AdaptadorRecyclerVW.ViewHolder> {

    private LayoutInflater layoutInflater;

    private View.OnClickListener onClickListener;

    public  AdaptadorRecyclerVW(Context context){

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public AdaptadorRecyclerVW.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = layoutInflater.inflate(R.layout.list_simple_element ,parent, false);

        view.setOnClickListener(onClickListener);

        return new ViewHolder(view);

    }

    public void setOnClickListener(View.OnClickListener onClickListener){

        this.onClickListener = onClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerVW.ViewHolder holder , int position){

        List periodo = root.list.get(position);

        Date date = new Date((long)root.list.get(position).dt*1000);

        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");

        SimpleDateFormat dateDay = new SimpleDateFormat("dd / MM / yyyy");

        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, holder.icon);

        holder.dia.setText(dateDayOfWeek.format(date));

        holder.precipitacion.setText(periodo.weather.get(0).description);

        holder.fecha.setText(dateDay.format(date));

        holder.hora.setText(hour.format(date));

        holder.temperatura.setText("Temp " + String.valueOf(periodo.main.temp) + "º");

        holder.maxima.setText("Max " + String.valueOf(periodo.main.temp_max) + "º");

        holder.minima.setText("Min " + String.valueOf(periodo.main.temp_min) + "º");

    }

    @Override
    public int getItemCount(){

        return root.list.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;

        private TextView dia, fecha, hora, precipitacion, temperatura, maxima , minima;

        public ViewHolder(@NonNull View itemView){

            super(itemView);

            icon = itemView.findViewById(R.id.icon);

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
