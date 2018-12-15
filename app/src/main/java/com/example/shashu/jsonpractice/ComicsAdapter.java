package com.example.shashu.jsonpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.io.Serializable;
import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {
    Context context;
    List<ResultComics> data;
    List<Price> prices;

    public ComicsAdapter(Context context, List<ResultComics> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ComicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_comics, viewGroup, false);
        return new ComicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicsViewHolder comicsViewHolder, int i) {
        final ResultComics result = data.get(i);
        final int position = i;
        comicsViewHolder.txtComicName.setText(result.getTitle());
        final String thumbnail = result.getThumbnail().getPath() + /*"/" + "portrait_medium" + */"." + result.getThumbnail().getExtension();
        Glide.with(comicsViewHolder.imgComics.getContext()).load(thumbnail).into(comicsViewHolder.imgComics);
        comicsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     Toast.makeText(context, result.getTitle() + " was clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ComicsInfo.class);
                intent.putExtra("title", result.getTitle());
                intent.putExtra("comic_image", thumbnail);
                intent.putExtra("isbn", result.getIsbn());
                intent.putExtra("pages_count", result.getPageCount());
                intent.putExtra("modified", result.getModified());
                intent.putExtra("description", result.getDescription());
               // String p=result.getPrices().get(position).getPrice();
                intent.putExtra("price", result.getPrices().get(0).getPrice());
//                Bundle bundle=new Bundle();
//                for(int i=0;i<result.getPrices().size();i++)
//                {
//                    Price p=result.getPrices().get(i);
//                    prices.add(p);
//                }
//              bundle.putSerializable("prices",(Serializable)prices);
//                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ComicsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgComics;
        TextView txtComicName;

        public ComicsViewHolder(View view) {
            super(view);
            imgComics = view.findViewById(R.id.imgComics);
            txtComicName = view.findViewById(R.id.txtComicsName);
        }
    }
}
