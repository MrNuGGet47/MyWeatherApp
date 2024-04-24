package com.example.myweatherbase.activities;

import static com.example.myweatherbase.activities.InfHours.root;

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

public class RecyclerVWAdapter extends RecyclerView.Adapter<RecyclerVWAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    private View.OnClickListener onClickListener;

    public RecyclerVWAdapter(Context context){

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public RecyclerVWAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = layoutInflater.inflate(R.layout.list_simple_element ,parent, false);

        view.setOnClickListener(onClickListener);

        return new ViewHolder(view);

    }

    public void setOnClickListener(View.OnClickListener onClickListener){

        this.onClickListener = onClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVWAdapter.ViewHolder holder , int position){

        List period = root.list.get(position);

        Date date = new Date((long)root.list.get(position).dt*1000);

        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");

        SimpleDateFormat dateDay = new SimpleDateFormat("dd / MM / yyyy");

        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, holder.icon);

        holder.day.setText(dateDayOfWeek.format(date));

        holder.precipitation.setText(period.weather.get(0).description);

        holder.date.setText(dateDay.format(date));

        holder.hour.setText(hour.format(date));

        holder.temperature.setText("Temp " + String.valueOf(period.main.temp) + (Parameters.UNITS.equals("metric") ? "ºC" : "ºF"));

        holder.max.setText("Max " + String.valueOf(period.main.temp_max) + (Parameters.UNITS.equals("metric") ? "ºC" : "ºF"));

        holder.min.setText("Min " + String.valueOf(period.main.temp_min) + (Parameters.UNITS.equals("metric") ? "ºC" : "ºF"));

    }

    @Override
    public int getItemCount(){

        return root.list.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;

        private TextView day, date, hour, precipitation, temperature, max, min;

        public ViewHolder(@NonNull View itemView){

            super(itemView);

            icon = itemView.findViewById(R.id.icon);

            day = itemView.findViewById(R.id.day);

            date = itemView.findViewById(R.id.date);

            hour = itemView.findViewById(R.id.hour);

            temperature = itemView.findViewById(R.id.temp);

            max = itemView.findViewById(R.id.max);

            min = itemView.findViewById(R.id.min);

            precipitation = itemView.findViewById(R.id.precipitation);

        }
    }
}
