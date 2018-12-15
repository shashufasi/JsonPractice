package com.example.shashu.jsonpractice;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter_Trailers extends RecyclerView.Adapter<Adapter_Trailers.Trailers_ViewHolder> {

    Context context;
    List<Trailer_Characters> trailer_characters;

    public Adapter_Trailers(Context context, List<Trailer_Characters> trailer_characters) {
        this.context = context;
        this.trailer_characters = trailer_characters;
    }

    @NonNull
    @Override
    public Trailers_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_trailer, null);
        return new Trailers_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Trailers_ViewHolder trailers_viewHolder, int i) {
        Trailer_Characters characters = trailer_characters.get(i);
        trailers_viewHolder.trailer_name.setText(characters.getTrailer_name());
        trailers_viewHolder.trailer_thumbnail.setImageResource(characters.getTrailer_thumbnail());
        trailers_viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Toast.makeText(context,"Trailer Opening...",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,TrailerActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailer_characters.size();
    }

    public class Trailers_ViewHolder extends RecyclerView.ViewHolder {
        ImageView trailer_thumbnail;
        TextView trailer_name;

        public Trailers_ViewHolder(View view) {
            super(view);
            trailer_thumbnail = view.findViewById(R.id.trailer_thumbnail);
            trailer_name = view.findViewById(R.id.trailer_name);
        }
    }
}
