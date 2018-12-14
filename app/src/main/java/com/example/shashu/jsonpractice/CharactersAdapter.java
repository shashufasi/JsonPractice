package com.example.shashu.jsonpractice;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.GitHubViewHolder> {

    private List<Result> data;
    private Context context;

    public CharactersAdapter(Context context, List<Result> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_layout_file, viewGroup, false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder gitHubViewHolder, int i) {
        final Result user = data.get(i);
        //  List<ResultComics> results=user.getResults();
        gitHubViewHolder.txtView.setText(user.getName());
        String thumbnail = user.getThumbnail().getPath() + "/" + "portrait_medium" + "." + user.getThumbnail().getExtension();
        Glide.with(gitHubViewHolder.imgView.getContext()).load(thumbnail).into(gitHubViewHolder.imgView);
        gitHubViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getName() + " was clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Character_Bio.class);
                i.putExtra("description", user.getDescription());
                i.putExtra("name", user.getName());
              //  Log.d("Path:",user.getThumbnail().getPath() + "/" + "portrait_medium" + "." + user.getThumbnail().getExtension());
                i.putExtra("thumbnail", user.getThumbnail().getPath() /*+ "/" + "portrait_medium"*/ + "." + user.getThumbnail().getExtension());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class GitHubViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtView;

        public GitHubViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgAvatar);
            txtView = itemView.findViewById(R.id.txtUser);
        }
    }
}
