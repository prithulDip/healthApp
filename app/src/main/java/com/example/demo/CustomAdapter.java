package com.example.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * using this class we show our recorded values in the RecyclerView
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id, date, time, sis,dia,harte,comment;
    int position;

    /**
     * constructor for CustomAdapter class
     * @param activity
     * @param context
     * @param id
     * @param date
     * @param time
     * @param sis
     * @param dia
     * @param harte
     * @param comment
     */
    CustomAdapter(Activity activity,Context context, ArrayList id, ArrayList date, ArrayList time,
                  ArrayList sis, ArrayList dia, ArrayList harte ,ArrayList comment){
        this.position = position;
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.date = date;
        this.time = time;
        this.sis = sis;
        this.dia = dia;
        this.harte = harte;
        this.comment=comment;


    }

    @NonNull
    @Override
    /**
     * Define layout for each item
     */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    /**
     * add values for each properties of my_row
     * @param holder
     * @param position
     * makes every row clickable
     * clicking a row redirects to showData activity
     */
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.time_txt.setText(String.valueOf(time.get(position)));
        holder.sis_txt.setText(String.valueOf(sis.get(position)));
        holder.dia_txt.setText(String.valueOf(dia.get(position)));
        holder.hrate_txt.setText(String.valueOf(harte.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowData.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("date", String.valueOf(date.get(position)));
                intent.putExtra("time", String.valueOf(time.get(position)));
                intent.putExtra("dia", String.valueOf(dia.get(position)));
                intent.putExtra("sis", String.valueOf(sis.get(position)));
                intent.putExtra("Hrate", String.valueOf(harte.get(position)));
                intent.putExtra("Comment", String.valueOf(comment.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    /**
     * find out how many rows in the database
     * @return int
     */
    @Override
    public int getItemCount() {
        return id.size();
    }

    /**
     * maps with every elements of my_row.xml
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt, date_txt, time_txt, sis_txt,dia_txt,hrate_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //id_txt = itemView.findViewById(R.id.idViewOut);
            date_txt = itemView.findViewById(R.id.dateViewOut);
            time_txt = itemView.findViewById(R.id.timeViewOut);
            sis_txt = itemView.findViewById(R.id.sistolicOut);
            dia_txt = itemView.findViewById(R.id.diaViewOut);
            hrate_txt = itemView.findViewById(R.id.hrateViewOut);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}
